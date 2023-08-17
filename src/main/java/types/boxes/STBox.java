package types.boxes;

import functions.functions;
import types.TemporalObject;
import types.core.DateTimeFormatHelper;
import types.core.TypeName;
import jnr.ffi.Pointer;
import net.postgis.jdbc.geometry.Geometry;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.Arrays;

import types.temporal.Temporal;
import types.time.Period;
import types.time.PeriodSet;
import types.time.TimestampSet;

import static functions.functions.stbox_to_period;

/**
 * Class that represents the MobilityDB type STBox
 */
@TypeName(name = "stbox")
public class STBox extends Box {
	private Point pMin = null;
	private Point pMax = null;
	private OffsetDateTime tMin = null;
	private OffsetDateTime tMax = null;
	private boolean isGeodetic = false;
	private int srid = 0;
	private Pointer _inner = null;
	private boolean tmin_inc = true;
	private boolean tmax_inc = true;

	public STBox _get_box(TemporalObject<?> other) throws SQLException {
		return this._get_box(other,true,false);
	}

	public STBox _get_box(TemporalObject<?> other, boolean allow_space_only, boolean allow_time_only) throws SQLException {
		STBox other_box=null;

		if (other instanceof STBox){

		}

		if (allow_time_only) {
			switch (other) {
				case STBox st -> other_box = new STBox(st.get_inner());
				case Period p -> other_box = new STBox(functions.period_to_stbox(p.get_inner()));
				case PeriodSet ps -> other_box = new STBox(functions.periodset_to_stbox(ps.get_inner()));
				case TimestampSet ts -> other_box = new STBox(functions.timestampset_to_stbox(ts.get_inner()));
				default -> throw new TypeNotPresentException(other.getClass().toString(), new Throwable("Operation not supported with this type"));
			}
		}
		return other_box;
	}
	/**
	 * The default constructor
	 */
	public STBox() {
		super();
	}
	
	public STBox(Pointer inner) throws SQLException {
		this(inner, true, true, false);
	}
	
	public STBox(Pointer inner, boolean tmin_inc, boolean tmax_inc, boolean geodetic) throws SQLException {
		super();
		this._inner = inner;
		this.tmin_inc = tmin_inc;
		this.tmax_inc = tmax_inc;
		this.isGeodetic = geodetic;
		String str = functions.stbox_out(this._inner,2);
		setValue(str);
	}
	
	/**
	 * The string constructor
	 *
	 * @param value - STBox value
	 * @throws SQLException
	 */
	
	public STBox(final String value) throws SQLException {
		super();
		setValue(value);
		this._inner = functions.stbox_in(value);

	}
	
	/**
	 * The constructor for only value dimension (x,y) or (x,y,z)
	 *
	 * @param pMin - coordinates for minimum bound
	 * @param pMax - coordinates for maximum bound
	 * @throws SQLException
	 */
	public STBox(Point pMin, Point pMax, Pointer inner) throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for value dimension (x,y) or (x,y,z) and time dimension
	 *
	 * @param pMin - coordinates for minimum bound
	 * @param tMin - minimum time dimension
	 * @param pMax - coordinates for maximum bound
	 * @param tMax - maximum time dimension
	 * @throws SQLException
	 */
	public STBox(Point pMin, OffsetDateTime tMin, Point pMax, OffsetDateTime tMax, Pointer inner) throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.tMin = tMin;
		this.tMax = tMax;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for only time dimension
	 *
	 * @param tMin - minimum time dimension
	 * @param tMax - maximum time dimension
	 * @throws SQLException
	 */
	public STBox(OffsetDateTime tMin, OffsetDateTime tMax, Pointer inner) throws SQLException {
		super();
		this.tMin = tMin;
		this.tMax = tMax;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for value dimension (x,y,z) with geodetic coordinates
	 *
	 * @param pMin       - coordinates for minimum bound
	 * @param pMax       - coordinates for maximum bound
	 * @param isGeodetic - if the coordinates are spherical
	 * @throws SQLException
	 */
	public STBox(Point pMin, Point pMax, boolean isGeodetic, Pointer inner) throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.isGeodetic = isGeodetic;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for value dimension (x,y,z) with geodetic coordinates and time dimension
	 *
	 * @param pMin       - coordinates for minimum bound
	 * @param tMin       - minimum time dimension
	 * @param pMax       - coordinates for maximum bound
	 * @param tMax       - maximum time dimension
	 * @param isGeodetic - if the coordinates are spherical
	 * @throws SQLException
	 */
	public STBox(Point pMin, OffsetDateTime tMin, Point pMax, OffsetDateTime tMax, boolean isGeodetic, Pointer inner)
			throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.tMin = tMin;
		this.tMax = tMax;
		this.isGeodetic = isGeodetic;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for geodetic box with only time dimension
	 *
	 * @param tMin       - minimum time dimension
	 * @param tMax       - maximum time dimension
	 * @param isGeodetic - if the coordinates are spherical
	 * @throws SQLException
	 */
	public STBox(OffsetDateTime tMin, OffsetDateTime tMax, boolean isGeodetic, Pointer inner) throws SQLException {
		super();
		this.tMin = tMin;
		this.tMax = tMax;
		this.isGeodetic = isGeodetic;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for only value dimension (x,y) or (x,y,z) and SRID
	 *
	 * @param pMin - coordinates for minimum bound
	 * @param pMax - coordinates for maximum bound
	 * @param srid - spatial reference identifier
	 * @throws SQLException
	 */
	public STBox(Point pMin, Point pMax, int srid, Pointer inner) throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.srid = srid;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for value dimension (x,y) or (x,y,z), time dimension and SRID
	 *
	 * @param pMin - coordinates for minimum bound
	 * @param tMin - minimum time dimension
	 * @param pMax - coordinates for maximum bound
	 * @param tMax - maximum time dimension
	 * @param srid - spatial reference identifier
	 * @throws SQLException
	 */
	public STBox(Point pMin, OffsetDateTime tMin, Point pMax, OffsetDateTime tMax, int srid, Pointer inner) throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.tMin = tMin;
		this.tMax = tMax;
		this.srid = srid;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for only time dimension and SRID
	 *
	 * @param tMin - minimum time dimension
	 * @param tMax - maximum time dimension
	 * @param srid - spatial reference identifier
	 * @throws SQLException
	 */
	public STBox(OffsetDateTime tMin, OffsetDateTime tMax, int srid, Pointer inner) throws SQLException {
		super();
		this.tMin = tMin;
		this.tMax = tMax;
		this.srid = srid;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for value dimension (x,y,z) with geodetic coordinates and SRID
	 *
	 * @param pMin       - coordinates for minimum bound
	 * @param pMax       - coordinates for maximum bound
	 * @param isGeodetic - if the coordinates are spherical
	 * @param srid       - spatial reference identifier
	 * @throws SQLException
	 */
	public STBox(Point pMin, Point pMax, boolean isGeodetic, int srid, Pointer inner) throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.isGeodetic = isGeodetic;
		this.srid = srid;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for value dimension (x,y,z) with geodetic coordinates, time dimension and SRID
	 *
	 * @param pMin       - coordinates for minimum bound
	 * @param tMin       - minimum time dimension
	 * @param pMax       - coordinates for maximum bound
	 * @param tMax       - maximum time dimension
	 * @param isGeodetic - if the coordinates are spherical
	 * @param srid       - spatial reference identifier
	 * @throws SQLException
	 */
	public STBox(Point pMin, OffsetDateTime tMin, Point pMax, OffsetDateTime tMax, boolean isGeodetic, int srid, Pointer inner)
			throws SQLException {
		super();
		this.pMin = pMin;
		this.pMax = pMax;
		this.tMin = tMin;
		this.tMax = tMax;
		this.isGeodetic = isGeodetic;
		this.srid = srid;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * The constructor for geodetic box with only time dimension and SRID
	 *
	 * @param tMin       - minimum time dimension
	 * @param tMax       - maximum time dimension
	 * @param isGeodetic - if the coordinates are spherical
	 * @param srid       - spatial reference identifier
	 * @throws SQLException
	 */
	public STBox(OffsetDateTime tMin, OffsetDateTime tMax, boolean isGeodetic, int srid, Pointer inner) throws SQLException {
		super();
		this.tMin = tMin;
		this.tMax = tMax;
		this.isGeodetic = isGeodetic;
		this.srid = srid;
		validate();
		if (inner != null) {
			this._inner = inner;
		}
	}
	
	/**
	 * Function that produces an STBox from a string through MEOS.
	 *
	 * @param hexwkb
	 * @return a JNR-FFI pointer
	 */
	
	public static STBox from_hexwkb(String hexwkb) throws SQLException {
		Pointer result = functions.stbox_from_hexwkb(hexwkb);
		return new STBox(result);
	}
	
	
	//To modify for pointer
    /*
    public String as_hexwkb(){
        return stbox_as_hexwkb(this._inner,-1,this._inner.size())[0];
    }
   */
	
	
	public STBox from_geometry(Geometry geom) throws SQLException {
		Pointer gs = functions.gserialized_in(geom.toString(), -1);
		return new STBox(functions.geo_to_stbox(gs));
	}
	
	
	public STBox from_space(Geometry value) throws SQLException {
		return from_geometry(value);
	}


    /*
    //Add the datetime_to_timestamptz function to the class
    public STBox from_datetime(Pointer time){
        Pointer result;
        //Add the datetime_to_timestamptz function to the class
        result = timestamp_to_stbox(datetime_to_timestamptz(time));
        return new STBox(result);
    }

     */
	
	
	public STBox from_timestampset(Pointer time) throws SQLException {
		Pointer result = functions.timestampset_to_stbox(time);
		return new STBox(result);
	}
	
	public STBox from_period(Pointer time) throws SQLException {
		Pointer result = functions.period_to_stbox(time);
		return new STBox(result);
	}
	
	public STBox from_periodset(Pointer time) throws SQLException {
		Pointer result = functions.periodset_to_stbox(time);
		return new STBox(result);
	}
	
	/*
	public STBox from_expanding_bounding_box_geom(Geometry value, float expansion) {
		Pointer gs = functions.gserialized_in(value.toString(), -1);
		Pointer result = functions.geo_expand_spatial(gs, expansion);
		return new STBox(result);
	}

	 */


    /* Modify Tpoint type
    public STBox from_expanding_bounding_box_tpoint(TPoint value, float expansion){
        Pointer result = tpoint_expand_spatial(value._inner, expansion);
        return new STBox(result);
    }

     */

    /*
    //Modify the from geometry datetime function
    public STBox from_space_datetime(Geometry value, Pointer time){
        return from_geometry_datetime(value,time);
    }

    public STBox from_space_period(Geometry value, Pointer time ){
        return from_geometry_period(value,time);
    }

     */


    /*
    //Modify Period type
    public STBox from_geometry_datetime(Geometry geometry, Pointer datetime){
        Pointer gs = gserialized_in(geometry.toString(),-1);
        Pointer result = geo_timestamp_to_stbox(gs,datetime_to_timestamptz(datetime));
        return new STBox(result);
    }

    public STBox from_geometry_period(Geometry geometry, Pointer period){
        Pointer gs = gserialized_in(geometry.toString(),-1);
        Pointer result = geo_period_to_stbox(gs,period._inner);
        return new STBox(result);
    }

    public STBox from_tpoint(TPoint temporal){
        return new STBox(tpoint_to_stbox(temporal._inner));
    }

     */
	
	
	//Add the shapely package ?
    /*
    public BaseGeometry to_geometry(int precision){
        return gserialized_to_shapely_geometry(stbox_to_geo(this._inner),precision);
    }

     */

    @Override
    public Period to_period() throws SQLException {
        Pointer result = stbox_to_period(this._inner);
        return new Period(result);
    }


	
	public boolean has_xy() {
		return functions.stbox_hasx(this._inner);
	}
	
	public boolean has_z() {
		return functions.stbox_hasz(this._inner);
	}
	
	public boolean has_t() {
		return functions.stbox_hast(this._inner);
	}
	
	public boolean geodetic() {
		return functions.stbox_isgeodetic(this._inner);
	}




    /*
    //Check the following with pointer double
    public boolean xmin(){
        return stbox_xmin(this._inner);
    }
    public boolean ymin(){
        return stbox_ymin(this._inner);
    }
    public boolean zmin(){
        return stbox_zmin(this._inner);
    }
    public boolean tmin(){
        return stbox_tmin(this._inner);
    }
    public boolean xmax(){
        return stbox_xmax(this._inner);
    }
    public boolean ymax(){
        return stbox_ymax(this._inner);
    }
    public boolean zmax(){
        return stbox_zmax(this._inner);
    }
    public boolean tmax(){
        return stbox_tmax(this._inner);
    }

     */
	
	
	public STBox expand_stbox(STBox stbox, STBox other) throws SQLException {
		Pointer result = functions.stbox_copy(this._inner);
		functions.stbox_expand(other._inner, result);
		return new STBox(result);
	}

	public STBox expand_numerical(Number value) throws SQLException {
		STBox result = null;
		if(Integer.class.isInstance(value) || Float.class.isInstance(value)){
			result = new STBox(functions.stbox_expand_space(this.get_inner(),(float) value));
		}
		return result;
	}



    /*
    //Add the timedelta function
    public STBox expand_timedelta(STBox stbox, Duration duration){
        Pointer result = stbox_expand_temporal(this._inner, timedelta_to_interval(duration));
        return new STBox(result);
    }

     */
	
	public STBox union(STBox other, boolean strict) throws SQLException {
		return new STBox(functions.union_stbox_stbox(this._inner, other._inner, strict));
	}

	public STBox intersection(STBox other) throws SQLException {
		return new STBox(functions.intersection_stbox_stbox(this._inner,other.get_inner()));
	}

	public boolean is_adjacent(TemporalObject<?> other) throws SQLException {
		return functions.adjacent_stbox_stbox(this._inner,this._get_box(other,true,true).get_inner());
	}

	public boolean is_contained_in(TemporalObject<?> other) throws SQLException {
		return functions.contained_stbox_stbox(this._inner,this._get_box(other,true,true).get_inner());
	}

	public boolean contains(TemporalObject<?> other) throws SQLException {
		return functions.contains_stbox_stbox(this._inner,this._get_box(other,true,true).get_inner());
	}

	public boolean overlaps(TemporalObject<?> other) throws SQLException {
		return functions.overlaps_stbox_stbox(this._inner,this._get_box(other,true,true).get_inner());
	}

	public boolean is_same(TemporalObject<?> other) throws SQLException {
		return functions.same_stbox_stbox(this._inner,this._get_box(other,true,true).get_inner());
	}

	public boolean is_left(TemporalObject<?> other) throws SQLException {
		return functions.left_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_over_or_left(TemporalObject<?> other) throws SQLException {
		return functions.overleft_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_right(TemporalObject<?> other) throws SQLException {
		return functions.right_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_over_or_right(TemporalObject<?> other) throws SQLException {
		return functions.overright_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_below(TemporalObject<?> other) throws SQLException {
		return functions.below_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_over_or_below(TemporalObject<?> other) throws SQLException {
		return functions.overbelow_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_above(TemporalObject<?> other) throws SQLException {
		return functions.above_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_over_or_above(TemporalObject<?> other) throws SQLException {
		return functions.overabove_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_front(TemporalObject<?> other) throws SQLException {
		return functions.front_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_over_or_front(TemporalObject<?> other) throws SQLException {
		return functions.overfront_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_behind(TemporalObject<?> other) throws SQLException {
		return functions.back_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_over_or_behind(TemporalObject<?> other) throws SQLException {
		return functions.overback_stbox_stbox(this._inner,this._get_box(other).get_inner());
	}

	public boolean is_before(TemporalObject<?> other) throws SQLException {
		return this.to_period().is_before(other);
	}

	public boolean is_over_or_before(TemporalObject<?> other) throws SQLException {
		return this.to_period().is_over_or_before(other);
	}

	public boolean is_after(TemporalObject<?> other) throws SQLException {
		return this.to_period().is_after(other);
	}

	public boolean is_over_or_after(TemporalObject<?> other) throws SQLException {
		return this.to_period().is_over_or_after(other);
	}
	
	public float nearest_approach_distance_geom(Geometry other) {
		Pointer gs = functions.gserialized_in(other.toString(), -1);
		return (float) functions.nad_stbox_geo(this._inner, gs);
	}
	
	public float nearest_approach_distance_stbox(STBox other) {
		return (float) functions.nad_stbox_stbox(this._inner, other._inner);
	}
	
	
	@Override
	public String getValue() {
		String sridPrefix = "";
		if (srid != 0) {
			sridPrefix = String.format("SRID=%s;", srid);
		}
		if (isGeodetic) {
			return getGeodeticValue(sridPrefix);
		} else {
			return getNonGeodeticValue(sridPrefix);
		}
	}
	
	@Override
	public void setValue(String value) throws SQLException {
		boolean hasZ;
		boolean hasT;
		if (value.startsWith("SRID")) {
			String[] initialValues = value.split(";");
			srid = Integer.parseInt(initialValues[0].split("=")[1]);
			value = initialValues[1];
		}
		
		if (value.contains("GEODSTBOX")) {
			isGeodetic = true;
			value = value.replace("GEODSTBOX", "");
			hasZ = true;
			hasT = value.contains("T");
		} else if (value.startsWith("STBOX")) {
			value = value.replace("STBOX", "");
			hasZ = value.contains("Z");
			hasT = value.contains("T");
		} else {
			throw new SQLException("Could not parse STBox value");
		}
		value = value.replace("Z", "")
				.replace("T", "")
				.replace("(", "")
				.replace(")", "");
		String[] values = value.split(",");
		int nonEmpty = (int) Arrays.stream(values).filter(x -> !x.isEmpty()).count();
		if (nonEmpty == 2) {
			String[] removedNull = Arrays.stream(values)
					.filter(x -> !x.isEmpty())
					.toArray(String[]::new);
			this.tMin = DateTimeFormatHelper.getDateTimeFormat(removedNull[0].trim());
			this.tMax = DateTimeFormatHelper.getDateTimeFormat(removedNull[1].trim());
		} else {
			this.pMin = new Point();
			this.pMax = new Point();
			if (nonEmpty >= 4) {
				this.pMin.setX(Double.parseDouble(values[0]));
				this.pMax.setX(Double.parseDouble(values[nonEmpty / 2]));
				this.pMin.setY(Double.parseDouble(values[1]));
				this.pMax.setY(Double.parseDouble(values[1 + nonEmpty / 2]));
			} else {
				throw new SQLException("Could not parse STBox value, invalid number of parameters.");
			}
			if (hasZ) {
				this.pMin.setZ(Double.parseDouble(values[2]));
				this.pMax.setZ(Double.parseDouble(values[2 + nonEmpty / 2]));
			}
			if (hasT) {
				this.tMin = DateTimeFormatHelper.getDateTimeFormat(values[nonEmpty / 2 - 1].trim());
				this.tMax = DateTimeFormatHelper.getDateTimeFormat(values[(nonEmpty / 2 - 1) + nonEmpty / 2].trim());
			}
		}
		validate();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof STBox) {
			STBox other = (STBox) obj;
			
			boolean pMinIsEqual;
			boolean pMaxIsEqual;
			
			if (pMin != null && other.pMin != null) {
				pMinIsEqual = pMin.equals(other.pMin);
			} else {
				pMinIsEqual = pMin == other.pMin;
			}
			
			if (pMax != null && other.pMax != null) {
				pMaxIsEqual = pMax.equals(other.pMax);
			} else {
				pMaxIsEqual = pMax == other.pMax;
			}
			
			return tIsEqual(other) && pMinIsEqual && pMaxIsEqual && isGeodetic == other.isGeodetic();
		}
		return false;
	}
	
	/**
	 * Compares if the values in time dimension are the same
	 *
	 * @param other - a STBox to compare
	 * @return true if they are equals; otherwise false
	 */
	public boolean tIsEqual(STBox other) {
		boolean tMinIsEqual;
		boolean tMaxIsEqual;
		
		if (tMin != null && other.getTMin() != null) {
			tMinIsEqual = tMin.isEqual(other.getTMin());
		} else {
			tMinIsEqual = tMin == other.getTMin();
		}
		
		if (tMax != null && other.getTMax() != null) {
			tMaxIsEqual = tMax.isEqual(other.getTMax());
		} else {
			tMaxIsEqual = tMax == other.getTMax();
		}
		
		return tMinIsEqual && tMaxIsEqual;
	}
	
	@Override
	public int hashCode() {
		String value = getValue();
		return value != null ? value.hashCode() : 0;
	}
	
	public Double getXmin() {
		return pMin != null ? pMin.getX() : null;
	}
	
	public Double getXmax() {
		return pMax != null ? pMax.getX() : null;
	}
	
	public Double getYmin() {
		return pMin != null ? pMin.getY() : null;
	}
	
	public Double getYmax() {
		return pMax != null ? pMax.getY() : null;
	}
	
	public Double getZmin() {
		return pMin != null ? pMin.getZ() : null;
	}
	
	public Double getZmax() {
		return pMax != null ? pMax.getZ() : null;
	}

	public boolean get_tmin_inc(){
		return tmin_inc;
	}

	public boolean get_tmax_inc(){
		return tmax_inc;
	}
	
	public OffsetDateTime getTMin() {
		return tMin;
	}
	
	public OffsetDateTime getTMax() {
		return tMax;
	}
	
	public boolean isGeodetic() {
		return isGeodetic;
	}
	
	public int getSrid() {
		return srid;
	}
	
	/**
	 * Verifies that the received fields are valid
	 *
	 * @throws SQLException
	 */
	private void validate() throws SQLException {
		if (tMin == null ^ tMax == null) {
			throw new SQLException("Both tmin and tmax should have a value.");
		}
		
		if (pMin != null && pMax != null) {
			if ((pMin.getX() == null ^ pMax.getX() == null) ^ (pMin.getY() == null ^ pMax.getY() == null)) {
				throw new SQLException("Both x and y coordinates should have a value.");
			}
			
			if (pMin.getZ() == null ^ pMax.getZ() == null) {
				throw new SQLException("Both zmax and zmin should have a value.");
			}
			
			if (isGeodetic && pMin.getZ() == null) {
				throw new SQLException("Geodetic coordinates need z value.");
			}
			
			if (pMin.getX() == null && tMin == null) {
				throw new SQLException("Could not parse STBox value, invalid number of arguments.");
			}
		}
	}
	
	/**
	 * Gets a string for geodetic values
	 *
	 * @param sridPrefix - a string that contains the SRID
	 * @return the STBox string with geodetic values
	 */
	private String getGeodeticValue(String sridPrefix) {
		if (tMin != null) {
			if (pMin != null) {
				return String.format("%sGEODSTBOX T((%f, %f, %f, %s), (%f, %f, %f, %s))", sridPrefix,
						pMin.getX(), pMin.getY(), pMin.getZ(), tMin, pMax.getX(), pMax.getY(), pMax.getZ(), tMax);
			}
			return String.format("%sGEODSTBOX T((, %s), (, %s))", sridPrefix, tMin, tMax);
		}
		return String.format("%sGEODSTBOX((%f, %f, %f), (%f, %f, %f))", sridPrefix,
				pMin.getX(), pMin.getY(), pMin.getZ(), pMax.getX(), pMax.getY(), pMax.getZ());
	}
	
	/**
	 * Gets a string for non-geodetic values
	 *
	 * @param sridPrefix - a string that contains the SRID
	 * @return the STBox string with non-geodetic values
	 */
	private String getNonGeodeticValue(String sridPrefix) {
		if (pMin == null) {
			if (tMin != null) {
				return String.format("%sSTBOX T((, %s), (, %s))", sridPrefix, tMin, tMax);
			}
		} else if (pMin.getZ() == null) {
			if (tMin == null) {
				return String.format("%sSTBOX ((%f, %f), (%f, %f))", sridPrefix,
						pMin.getX(), pMin.getY(), pMax.getX(), pMax.getY());
			}
			return String.format("%sSTBOX T((%f, %f, %s), (%f, %f, %s))", sridPrefix,
					pMin.getX(), pMin.getY(), tMin, pMax.getX(), pMax.getY(), tMax);
		} else {
			if (tMin == null) {
				return String.format("%sSTBOX Z((%f, %f, %s), (%f, %f, %s))", sridPrefix,
						pMin.getX(), pMin.getY(), pMin.getZ(), pMax.getX(), pMax.getY(), pMax.getZ());
			}
			return String.format("%sSTBOX ZT((%f, %f, %f, %s), (%f, %f, %f, %s))", sridPrefix,
					pMin.getX(), pMin.getY(), pMin.getZ(), tMin, pMax.getX(), pMax.getY(), pMax.getZ(), tMax);
		}
		return null;
	}
}
