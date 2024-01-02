package types.basic.tpoint.tgeog;

import functions.functions;
import jnr.ffi.Pointer;
import types.basic.tbool.TBool;
import types.basic.tpoint.tgeom.TGeomPoint;
import types.collections.time.Period;
import types.collections.time.PeriodSet;
import types.collections.time.Time;
import types.collections.time.TimestampSet;
import types.temporal.Factory;
import types.temporal.TInterpolation;
import types.temporal.Temporal;
import types.basic.tpoint.TPoint;
import types.temporal.TemporalType;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import utils.ConversionUtils;


/**
 * Class that represents the MobilityDB type TGeogPoint
 */
public interface TGeogPoint extends TPoint {
	String customType = "Geog";
	Pointer getPointInner();
	String getCustomType();
	TemporalType getTemporalType();


    /*  ------------------------- Output ---------------------------------------- */


	/**
	 * Creates a temporal geographic point from a base geometry and the time
	 *         frame of another temporal object.
	 *
	 * <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_from_base_temp</li>
	 * @param value The base geometry.
	 * @param base The temporal object defining the time frame
	 * @return A new {@link TGeogPoint} object.
	 */
	default TGeogPoint from_base_temporal(Geometry value, Temporal base){
		return (TGeogPoint) Factory.create_temporal(functions.tpoint_from_base_temp(ConversionUtils.geography_to_gserialized(value),base.getInner()),getCustomType(),getTemporalType());
	}


	/**
	 * Creates a temporal geographic point from a base geometry and a time value.
	 *
	 * <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpointinst_make</li>
	 *             <li>tpointseq_from_base_timestampset</li>
	 *             <li>tpointseq_from_base_period</li>
	 *             <li>tpointseqset_from_base_periodset</li>
	 *
	 * @param value The base geometry.
	 * @param base The time value.
	 * @param interp  The interpolation method.
	 * @return A new {@link TGeogPoint} object.
	 */
	static TGeogPoint from_base_time(Geometry value, Time base, TInterpolation interp){
		if (base instanceof Period){
			return new TGeogPointSeq(functions.tpointseq_from_base_period(ConversionUtils.geography_to_gserialized(value), ((Period) base).get_inner(), interp.getValue()));
		} else if (base instanceof PeriodSet) {
			return new TGeogPointSeqSet(functions.tpointseqset_from_base_periodset(ConversionUtils.geography_to_gserialized(value), ((PeriodSet) base).get_inner(), interp.getValue()));
		} else if (base instanceof TimestampSet) {
			return new TGeogPointSeq(functions.tpointseq_from_base_timestampset(ConversionUtils.geography_to_gserialized(value), ((TimestampSet) base).get_inner()));
		}
		else{
			throw new UnsupportedOperationException("Operation not supported with type " + base.getClass());
		}
	}




    /* ------------------------- Conversions ---------------------------------- */


	/**
	 * Returns a copy of "this" converted to geometric coordinates.
	 *
	 * <p>
	 *
	 *         MEOS Functions:
	 *             <li>tgeogpoint_to_tgeompoint</li>
	 * @return A new {@link TGeomPoint} object.
	 */
	default TGeomPoint to_geometric(){
		return (TGeomPoint) Factory.create_temporal(functions.tgeogpoint_to_tgeompoint(getPointInner()),"Geom",getTemporalType());

	}



    /* ------------------------- Ever and Always Comparisons ------------------- */


	/**
	 * Returns whether "this" is always equal to "value".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_always_eq</li>
	 * @param value The geometry to compare with.
	 * @return True if "this" is always equal to "value", False otherwise.
	 */
	default boolean always_equal(Geometry value){
		return functions.tpoint_always_eq(getPointInner(),ConversionUtils.geography_to_gserialized(value));

	}

	/**
	 * Returns whether "this" is always different to "value".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_ever_eq</li>
	 * @param value The geometry to compare with.
	 * @return True if "this" is always different to "value", False otherwise.
	 */
	default boolean always_not_equal(Geometry value){
		return ! functions.tpoint_ever_eq(getPointInner(),ConversionUtils.geography_to_gserialized(value));
	}


	/**
	 * Returns whether "this" is ever equal to "value".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_ever_eq</li>
	 * @param value The geometry to compare with.
	 * @return True if "this" is ever equal to "value", False otherwise.
	 */
	default boolean ever_equal(Geometry value){
		return  functions.tpoint_ever_eq(getPointInner(),ConversionUtils.geography_to_gserialized(value));
	}


	/**
	 * Returns whether "this" is ever different to "value".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_always_eq</li>
	 * @param value The geometry to compare with.
	 * @return True if "this" is ever different to "value", False otherwise.
	 */
	default boolean ever_not_equal(Geometry value){
		return ! functions.tpoint_always_eq(getPointInner(),ConversionUtils.geography_to_gserialized(value));

	}


	/**
	 * Returns whether "this" is never equal to "value".
	 *
	 * <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_ever_eq</li>
	 * @param value The geometry to compare with.
	 * @return True if "this" is never equal to "value", False otherwise.
	 */
	default boolean never_equal(Geometry value){
		return ! functions.tpoint_ever_eq(getPointInner(),ConversionUtils.geography_to_gserialized(value));
	}


	/**
	 * Returns whether "self" is never different to "value".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>tpoint_always_eq</li>
	 * @param value The geometry to compare with.
	 * @return True if "self" is never different to "value", False otherwise.
	 */
	default boolean never_not_equal(Geometry value){
		return functions.tpoint_always_eq(getPointInner(),ConversionUtils.geography_to_gserialized(value));
	}



    /* ------------------------- Temporal Comparisons -------------------------- */


	/**
	 * Returns the temporal equality relation between "this" and "other".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>teq_tpoint_point</li>
	 *             <li>teq_temporal_temporal</li>
	 * @param other A temporal object to compare to "this".
	 * @return A {@link TBool} with the result of the temporal equality relation.
	 */
	default TBool temporal_equal(Point other){
		return (TBool) Factory.create_temporal(functions.teq_tpoint_point(getPointInner(), ConversionUtils.geography_to_gserialized(other)),getCustomType(),getTemporalType());
	}




	/**
	 * Returns the temporal inequality relation between "this" and "other".
	 *
	 *  <p>
	 *
	 *         MEOS Functions:
	 *             <li>tne_tpoint_point</li>
	 *             <li>tne_temporal_temporal</li>
	 * @param other A temporal object to compare to "this".
	 * @return A {@link TBool} with the result of the temporal inequality relation.
	 */
	default TBool temporal_not_equal(Point other){
		return (TBool) Factory.create_temporal(functions.tne_tpoint_point(getPointInner(), ConversionUtils.geography_to_gserialized(other)),getCustomType(),getTemporalType());
	}


    /* ------------------------- Database Operations --------------------------- */








}
