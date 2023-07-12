package function;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;
import jnr.ffi.types.int32_t;
import jnr.ffi.types.u_int64_t;
import jnr.ffi.types.u_int8_t;

public class functions {
	public interface MeosLibrary {

		functions.MeosLibrary INSTANCE = LibraryLoader.create(functions.MeosLibrary.class).load("meos");

		functions.MeosLibrary meos = functions.MeosLibrary.INSTANCE;

		Pointer lwpoint_make(int32_t srid, int hasz, int hasm, Pointer p);

		Pointer lwgeom_from_gserialized(Pointer g);

		Pointer gserialized_from_lwgeom(Pointer geom, Pointer size);

		Pointer lwgeom_as_lwpoint(Pointer lwgeom);

		int32_t lwgeom_get_srid(Pointer geom);

		double lwpoint_get_x(Pointer point);

		double lwpoint_get_y(Pointer point);

		double lwpoint_get_z(Pointer point);

		double lwpoint_get_m(Pointer point);

		int lwgeom_has_z(Pointer geom);

		int lwgeom_has_m(Pointer geom);

		void meos_initialize(byte[] tz_str);

		void meos_finish();

		boolean bool_in(String in_str);

		String bool_out(boolean b);

		DateADT pg_date_in(String str);

		String pg_date_out(DateADT date);

		int pg_interval_cmp(Pointer interval1, Pointer interval2);

		Pointer pg_interval_in(String str, int32_t typmod);

		Pointer pg_interval_make(int32_t years, int32_t months, int32_t weeks, int32_t days, int32_t hours, int32_t mins, double secs);

		String pg_interval_out(Pointer span);

		Pointer pg_interval_mul(Pointer span, double factor);

		Pointer pg_interval_pl(Pointer span1, Pointer span2);

		TimeADT pg_time_in(String str, int32_t typmod);

		String pg_time_out(TimeADT time);

		int pg_timestamp_in(String str, int32_t typmod);

		Pointer pg_timestamp_mi(int dt1, int dt2);

		int pg_timestamp_mi_interval(int timestamp, Pointer span);

		String pg_timestamp_out(int dt);

		int pg_timestamp_pl_interval(int timestamp, Pointer span);

		int pg_timestamptz_in(String str, int32_t typmod);

		String pg_timestamptz_out(int dt);

		Pointer gserialized_as_ewkb(Pointer geom, String type);

		String gserialized_as_geojson(Pointer geom, int option, int precision, String srs);

		String gserialized_as_hexewkb(Pointer geom, String type);

		String gserialized_as_text(Pointer geom, int precision);

		Pointer gserialized_from_ewkb(Pointer bytea_wkb, int32_t srid);

		Pointer gserialized_from_geojson(String geojson);

		Pointer gserialized_from_hexewkb(String wkt);

		Pointer gserialized_from_text(String wkt, int srid);

		Pointer gserialized_in(String input, int32_t geom_typmod);

		String gserialized_out(Pointer geom);

		boolean gserialized_same(Pointer geom1, Pointer geom2);

		Pointer floatspan_in(String str);

		String floatspan_out(Pointer s, int maxdd);

		Pointer intspan_in(String str);

		String intspan_out(Pointer s);

		Pointer period_in(String str);

		String period_out(Pointer s);

		String periodset_as_hexwkb(Pointer ps, u_int8_t variant, Pointer size_out);

		Pointer periodset_as_wkb(Pointer ps, u_int8_t variant, Pointer size_out);

		Pointer periodset_from_hexwkb(String hexwkb);

		Pointer periodset_from_wkb(Pointer wkb, int size);

		Pointer periodset_in(String str);

		String periodset_out(Pointer ps);

		String span_as_hexwkb(Pointer s, u_int8_t variant, Pointer size_out);

		Pointer span_as_wkb(Pointer s, u_int8_t variant, Pointer size_out);

		Pointer span_from_hexwkb(String hexwkb);

		Pointer span_from_wkb(Pointer wkb, int size);

		String span_out(Pointer s, int arg);

		String timestampset_as_hexwkb(Pointer ts, u_int8_t variant, Pointer size_out);

		Pointer timestampset_as_wkb(Pointer ts, u_int8_t variant, Pointer size_out);

		Pointer timestampset_from_hexwkb(String hexwkb);

		Pointer timestampset_from_wkb(Pointer wkb, int size);

		Pointer timestampset_in(String str);

		String timestampset_out(Pointer ts);

		Pointer floatspan_make(double lower, double upper, boolean lower_inc, boolean upper_inc);

		Pointer intspan_make(int lower, int upper, boolean lower_inc, boolean upper_inc);

		Pointer period_make(int lower, int upper, boolean lower_inc, boolean upper_inc);

		Pointer periodset_copy(Pointer ps);

		Pointer periodset_make(Pointer[] periods, int count, boolean normalize);

		Pointer periodset_make_free(Pointer[] periods, int count, boolean normalize);

		Pointer span_copy(Pointer s);

		Pointer timestampset_copy(Pointer ts);

		Pointer timestampset_make(Pointer times, int count);

		Pointer timestampset_make_free(Pointer times, int count);

		Pointer float_to_floaspan(double d);

		Pointer int_to_intspan(int i);

		Pointer period_to_periodset(Pointer period);

		Pointer periodset_to_period(Pointer ps);

		Pointer timestamp_to_period(int t);

		Pointer timestamp_to_periodset(int t);

		Pointer timestamp_to_timestampset(int t);

		Pointer timestampset_to_periodset(Pointer ts);

		double floatspan_lower(Pointer s);

		double floatspan_upper(Pointer s);

		int intspan_lower(Pointer s);

		int intspan_upper(Pointer s);

		Pointer period_duration(Pointer s);

		int period_lower(Pointer p);

		int period_upper(Pointer p);

		Pointer periodset_duration(Pointer ps);

		Pointer periodset_end_period(Pointer ps);

		int periodset_end_timestamp(Pointer ps);

		u_int32_t periodset_hash(Pointer ps);

		u_int64_t periodset_hash_extended(Pointer ps, u_int64_t seed);

		int periodset_mem_size(Pointer ps);

		int periodset_num_periods(Pointer ps);

		int periodset_num_timestamps(Pointer ps);

		Pointer periodset_period_n(Pointer ps, int i);

		Pointer periodset_start_period(Pointer ps);

		int periodset_start_timestamp(Pointer ps);

		Pointer periodset_timespan(Pointer ps);

		boolean periodset_timestamp_n(Pointer ps, int n, Pointer result);

		Pointer periodset_timestamps(Pointer ps, Pointer count);

		u_int32_t span_hash(Pointer s);

		u_int64_t span_hash_extended(Pointer s, u_int64_t seed);

		boolean span_lower_inc(Pointer s);

		boolean span_upper_inc(Pointer s);

		double span_width(Pointer s);

		int timestampset_end_timestamp(Pointer ss);

		u_int32_t timestampset_hash(Pointer ss);

		u_int64_t timestampset_hash_extended(Pointer ss, u_int64_t seed);

		int timestampset_mem_size(Pointer ss);

		int timestampset_num_timestamps(Pointer ss);

		int timestampset_start_timestamp(Pointer ss);

		Pointer timestampset_timespan(Pointer ss);

		boolean timestampset_timestamp_n(Pointer ss, int n, Pointer result);

		Pointer timestampset_timestamps(Pointer ss);

		Pointer periodset_shift_tscale(Pointer ps, Pointer start, Pointer duration);

		void span_expand(Pointer s1, Pointer s2);

		void period_shift_tscale(Pointer start, Pointer duration, Pointer result);

		Pointer timestampset_shift_tscale(Pointer ss, Pointer start, Pointer duration);

		boolean adjacent_floatspan_float(Pointer s, double d);

		boolean adjacent_intspan_int(Pointer s, int i);

		boolean adjacent_period_periodset(Pointer p, Pointer ps);

		boolean adjacent_period_timestamp(Pointer p, int t);

		boolean adjacent_period_timestampset(Pointer p, Pointer ts);

		boolean adjacent_periodset_period(Pointer ps, Pointer p);

		boolean adjacent_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean adjacent_periodset_timestamp(Pointer ps, int t);

		boolean adjacent_periodset_timestampset(Pointer ps, Pointer ts);

		boolean adjacent_span_span(Pointer s1, Pointer s2);

		boolean adjacent_timestamp_period(int t, Pointer p);

		boolean adjacent_timestamp_periodset(int t, Pointer ps);

		boolean adjacent_timestampset_period(Pointer ts, Pointer p);

		boolean adjacent_timestampset_periodset(Pointer ts, Pointer ps);

		boolean contained_float_floatspan(double d, Pointer s);

		boolean contained_int_intspan(int i, Pointer s);

		boolean contained_period_periodset(Pointer p, Pointer ps);

		boolean contained_periodset_period(Pointer ps, Pointer p);

		boolean contained_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean contained_span_span(Pointer s1, Pointer s2);

		boolean contained_timestamp_period(int t, Pointer p);

		boolean contained_timestamp_periodset(int t, Pointer ps);

		boolean contained_timestamp_timestampset(int t, Pointer ts);

		boolean contained_timestampset_period(Pointer ts, Pointer p);

		boolean contained_timestampset_periodset(Pointer ts, Pointer ps);

		boolean contained_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean contains_floatspan_float(Pointer s, double d);

		boolean contains_intspan_int(Pointer s, int i);

		boolean contains_period_periodset(Pointer p, Pointer ps);

		boolean contains_period_timestamp(Pointer p, int t);

		boolean contains_period_timestampset(Pointer p, Pointer ts);

		boolean contains_periodset_period(Pointer ps, Pointer p);

		boolean contains_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean contains_periodset_timestamp(Pointer ps, int t);

		boolean contains_periodset_timestampset(Pointer ps, Pointer ts);

		boolean contains_span_span(Pointer s1, Pointer s2);

		boolean contains_timestampset_timestamp(Pointer ts, int t);

		boolean contains_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean overlaps_period_periodset(Pointer p, Pointer ps);

		boolean overlaps_period_timestampset(Pointer p, Pointer ts);

		boolean overlaps_periodset_period(Pointer ps, Pointer p);

		boolean overlaps_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean overlaps_periodset_timestampset(Pointer ps, Pointer ts);

		boolean overlaps_span_span(Pointer s1, Pointer s2);

		boolean overlaps_timestampset_period(Pointer ts, Pointer p);

		boolean overlaps_timestampset_periodset(Pointer ts, Pointer ps);

		boolean overlaps_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean after_period_periodset(Pointer p, Pointer ps);

		boolean after_period_timestamp(Pointer p, int t);

		boolean after_period_timestampset(Pointer p, Pointer ts);

		boolean after_periodset_period(Pointer ps, Pointer p);

		boolean after_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean after_periodset_timestamp(Pointer ps, int t);

		boolean after_periodset_timestampset(Pointer ps, Pointer ts);

		boolean after_timestamp_period(int t, Pointer p);

		boolean after_timestamp_periodset(int t, Pointer ps);

		boolean after_timestamp_timestampset(int t, Pointer ts);

		boolean after_timestampset_period(Pointer ts, Pointer p);

		boolean after_timestampset_periodset(Pointer ts, Pointer ps);

		boolean after_timestampset_timestamp(Pointer ts, int t);

		boolean after_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean before_period_periodset(Pointer p, Pointer ps);

		boolean before_period_timestamp(Pointer p, int t);

		boolean before_period_timestampset(Pointer p, Pointer ts);

		boolean before_periodset_period(Pointer ps, Pointer p);

		boolean before_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean before_periodset_timestamp(Pointer ps, int t);

		boolean before_periodset_timestampset(Pointer ps, Pointer ts);

		boolean before_timestamp_period(int t, Pointer p);

		boolean before_timestamp_periodset(int t, Pointer ps);

		boolean before_timestamp_timestampset(int t, Pointer ts);

		boolean before_timestampset_period(Pointer ts, Pointer p);

		boolean before_timestampset_periodset(Pointer ts, Pointer ps);

		boolean before_timestampset_timestamp(Pointer ts, int t);

		boolean before_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean left_float_floatspan(double d, Pointer s);

		boolean left_floatspan_float(Pointer s, double d);

		boolean left_int_intspan(int i, Pointer s);

		boolean left_intspan_int(Pointer s, int i);

		boolean left_span_span(Pointer s1, Pointer s2);

		boolean overafter_period_periodset(Pointer p, Pointer ps);

		boolean overafter_period_timestamp(Pointer p, int t);

		boolean overafter_period_timestampset(Pointer p, Pointer ts);

		boolean overafter_periodset_period(Pointer ps, Pointer p);

		boolean overafter_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean overafter_periodset_timestamp(Pointer ps, int t);

		boolean overafter_periodset_timestampset(Pointer ps, Pointer ts);

		boolean overafter_timestamp_period(int t, Pointer p);

		boolean overafter_timestamp_periodset(int t, Pointer ps);

		boolean overafter_timestamp_timestampset(int t, Pointer ts);

		boolean overafter_timestampset_period(Pointer ts, Pointer p);

		boolean overafter_timestampset_periodset(Pointer ts, Pointer ps);

		boolean overafter_timestampset_timestamp(Pointer ts, int t);

		boolean overafter_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean overbefore_period_periodset(Pointer p, Pointer ps);

		boolean overbefore_period_timestamp(Pointer p, int t);

		boolean overbefore_period_timestampset(Pointer p, Pointer ts);

		boolean overbefore_periodset_period(Pointer ps, Pointer p);

		boolean overbefore_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean overbefore_periodset_timestamp(Pointer ps, int t);

		boolean overbefore_periodset_timestampset(Pointer ps, Pointer ts);

		boolean overbefore_timestamp_period(int t, Pointer p);

		boolean overbefore_timestamp_periodset(int t, Pointer ps);

		boolean overbefore_timestamp_timestampset(int t, Pointer ts);

		boolean overbefore_timestampset_period(Pointer ts, Pointer p);

		boolean overbefore_timestampset_periodset(Pointer ts, Pointer ps);

		boolean overbefore_timestampset_timestamp(Pointer ts, int t);

		boolean overbefore_timestampset_timestampset(Pointer ts1, Pointer ts2);

		boolean overleft_float_floatspan(double d, Pointer s);

		boolean overleft_floatspan_float(Pointer s, double d);

		boolean overleft_int_intspan(int i, Pointer s);

		boolean overleft_intspan_int(Pointer s, int i);

		boolean overleft_span_span(Pointer s1, Pointer s2);

		boolean overright_float_floatspan(double d, Pointer s);

		boolean overright_floatspan_float(Pointer s, double d);

		boolean overright_int_intspan(int i, Pointer s);

		boolean overright_intspan_int(Pointer s, int i);

		boolean overright_span_span(Pointer s1, Pointer s2);

		boolean right_float_floatspan(double d, Pointer s);

		boolean right_floatspan_float(Pointer s, double d);

		boolean right_int_intspan(int i, Pointer s);

		boolean right_intspan_int(Pointer s, int i);

		boolean right_span_span(Pointer s1, Pointer s2);

		Pointer intersection_period_periodset(Pointer p, Pointer ps);

		boolean intersection_period_timestamp(Pointer p, int t, Pointer result);

		Pointer intersection_period_timestampset(Pointer ps, Pointer ts);

		Pointer intersection_periodset_period(Pointer ps, Pointer p);

		Pointer intersection_periodset_periodset(Pointer ps1, Pointer ps2);

		boolean intersection_periodset_timestamp(Pointer ps, int t, Pointer result);

		Pointer intersection_periodset_timestampset(Pointer ps, Pointer ts);

		Pointer intersection_span_span(Pointer s1, Pointer s2);

		boolean intersection_timestamp_period(int t, Pointer p, Pointer result);

		boolean intersection_timestamp_periodset(int t, Pointer ps, Pointer result);

		boolean intersection_timestamp_timestamp(int t1, int t2, Pointer result);

		boolean intersection_timestamp_timestampset(int t, Pointer ts, Pointer result);

		Pointer intersection_timestampset_period(Pointer ts, Pointer p);

		Pointer intersection_timestampset_periodset(Pointer ts, Pointer ps);

		boolean intersection_timestampset_timestamp(Pointer ts, int t, Pointer result);

		Pointer intersection_timestampset_timestampset(Pointer ts1, Pointer ts2);

		Pointer minus_period_period(Pointer p1, Pointer p2);

		Pointer minus_period_periodset(Pointer p, Pointer ps);

		Pointer minus_period_timestamp(Pointer p, int t);

		Pointer minus_period_timestampset(Pointer p, Pointer ts);

		Pointer minus_periodset_period(Pointer ps, Pointer p);

		Pointer minus_periodset_periodset(Pointer ps1, Pointer ps2);

		Pointer minus_periodset_timestamp(Pointer ps, int t);

		Pointer minus_periodset_timestampset(Pointer ps, Pointer ts);

		Pointer minus_span_span(Pointer s1, Pointer s2);

		boolean minus_timestamp_period(int t, Pointer p, Pointer result);

		boolean minus_timestamp_periodset(int t, Pointer ps, Pointer result);

		boolean minus_timestamp_timestamp(int t1, int t2, Pointer result);

		boolean minus_timestamp_timestampset(int t, Pointer ts, Pointer result);

		Pointer minus_timestampset_period(Pointer ts, Pointer p);

		Pointer minus_timestampset_periodset(Pointer ts, Pointer ps);

		Pointer minus_timestampset_timestamp(Pointer ts, int t);

		Pointer minus_timestampset_timestampset(Pointer ts1, Pointer ts2);

		Pointer union_period_period(Pointer p1, Pointer p2);

		Pointer union_period_periodset(Pointer p, Pointer ps);

		Pointer union_period_timestamp(Pointer p, int t);

		Pointer union_period_timestampset(Pointer p, Pointer ts);

		Pointer union_periodset_period(Pointer ps, Pointer p);

		Pointer union_periodset_periodset(Pointer ps1, Pointer ps2);

		Pointer union_periodset_timestamp(Pointer ps, int t);

		Pointer union_periodset_timestampset(Pointer ps, Pointer ts);

		Pointer union_span_span(Pointer s1, Pointer s2, boolean strict);

		Pointer union_timestamp_period(int t, Pointer p);

		Pointer union_timestamp_periodset(int t, Pointer ps);

		Pointer union_timestamp_timestamp(int t1, int t2);

		Pointer union_timestamp_timestampset(int t, Pointer ts);

		Pointer union_timestampset_period(Pointer ts, Pointer p);

		Pointer union_timestampset_periodset(Pointer ts, Pointer ps);

		Pointer union_timestampset_timestamp(Pointer ts, int t);

		Pointer union_timestampset_timestampset(Pointer ts1, Pointer ts2);

		double distance_floatspan_float(Pointer s, double d);

		double distance_intspan_int(Pointer s, int i);

		double distance_period_periodset(Pointer p, Pointer ps);

		double distance_period_timestamp(Pointer p, int t);

		double distance_period_timestampset(Pointer p, Pointer ts);

		double distance_periodset_period(Pointer ps, Pointer p);

		double distance_periodset_periodset(Pointer ps1, Pointer ps2);

		double distance_periodset_timestamp(Pointer ps, int t);

		double distance_periodset_timestampset(Pointer ps, Pointer ts);

		double distance_span_span(Pointer s1, Pointer s2);

		double distance_timestamp_period(int t, Pointer p);

		double distance_timestamp_periodset(int t, Pointer ps);

		double distance_timestamp_timestamp(int t1, int t2);

		double distance_timestamp_timestampset(int t, Pointer ts);

		double distance_timestampset_period(Pointer ts, Pointer p);

		double distance_timestampset_periodset(Pointer ts, Pointer ps);

		double distance_timestampset_timestamp(Pointer ts, int t);

		double distance_timestampset_timestampset(Pointer ts1, Pointer ts2);

		Pointer timestamp_extent_transfn(Pointer p, int t);

		Pointer timestampset_extent_transfn(Pointer p, Pointer ts);

		Pointer span_extent_transfn(Pointer p1, Pointer p2);

		Pointer periodset_extent_transfn(Pointer p, Pointer ps);

		Pointer timestamp_tunion_transfn(Pointer state, int t);

		Pointer timestampset_tunion_transfn(Pointer state, Pointer ts);

		Pointer period_tunion_transfn(Pointer state, Pointer p);

		Pointer periodset_tunion_transfn(Pointer state, Pointer ps);

		Pointer timestamp_tunion_finalfn(Pointer state);

		Pointer period_tunion_finalfn(Pointer state);

		Pointer timestamp_tcount_transfn(Pointer state, int t, Pointer interval, int origin);

		Pointer timestampset_tcount_transfn(Pointer state, Pointer ts, Pointer interval, int origin);

		Pointer period_tcount_transfn(Pointer state, Pointer p, Pointer interval, int origin);

		Pointer periodset_tcount_transfn(Pointer state, Pointer ps, Pointer interval, int origin);

		boolean periodset_eq(Pointer ps1, Pointer ps2);

		boolean periodset_ne(Pointer ps1, Pointer ps2);

		int periodset_cmp(Pointer ps1, Pointer ps2);

		boolean periodset_lt(Pointer ps1, Pointer ps2);

		boolean periodset_le(Pointer ps1, Pointer ps2);

		boolean periodset_ge(Pointer ps1, Pointer ps2);

		boolean periodset_gt(Pointer ps1, Pointer ps2);

		boolean span_eq(Pointer s1, Pointer s2);

		boolean span_ne(Pointer s1, Pointer s2);

		int span_cmp(Pointer s1, Pointer s2);

		boolean span_lt(Pointer s1, Pointer s2);

		boolean span_le(Pointer s1, Pointer s2);

		boolean span_ge(Pointer s1, Pointer s2);

		boolean span_gt(Pointer s1, Pointer s2);

		boolean timestampset_eq(Pointer ss1, Pointer ss2);

		boolean timestampset_ne(Pointer ss1, Pointer ss2);

		int timestampset_cmp(Pointer ss1, Pointer ss2);

		boolean timestampset_lt(Pointer ss1, Pointer ss2);

		boolean timestampset_le(Pointer ss1, Pointer ss2);

		boolean timestampset_ge(Pointer ss1, Pointer ss2);

		boolean timestampset_gt(Pointer ss1, Pointer ss2);

		Pointer tbox_in(String str);

		String tbox_out(Pointer box, int maxdd);

		Pointer tbox_from_wkb(Pointer wkb, int size);

		Pointer tbox_from_hexwkb(String hexwkb);

		Pointer stbox_from_wkb(Pointer wkb, int size);

		Pointer stbox_from_hexwkb(String hexwkb);

		Pointer tbox_as_wkb(Pointer box, u_int8_t variant, Pointer size_out);

		String tbox_as_hexwkb(Pointer box, u_int8_t variant, Pointer size);

		Pointer stbox_as_wkb(Pointer box, u_int8_t variant, Pointer size_out);

		String stbox_as_hexwkb(Pointer box, u_int8_t variant, Pointer size);

		Pointer stbox_in(String str);

		String stbox_out(Pointer box, int maxdd);

		Pointer tbox_make(Pointer p, Pointer s);

		void tbox_set(Pointer p, Pointer s, Pointer box);

		Pointer tbox_copy(Pointer box);

		Pointer stbox_copy(Pointer box);

		Pointer int_to_tbox(int i);

		Pointer float_to_tbox(double d);

		Pointer span_to_tbox(Pointer span);

		Pointer timestamp_to_tbox(int t);

		Pointer timestampset_to_tbox(Pointer ss);

		Pointer period_to_tbox(Pointer p);

		Pointer periodset_to_tbox(Pointer ps);

		Pointer int_timestamp_to_tbox(int i, int t);

		Pointer float_timestamp_to_tbox(double d, int t);

		Pointer int_period_to_tbox(int i, Pointer p);

		Pointer float_period_to_tbox(double d, Pointer p);

		Pointer span_timestamp_to_tbox(Pointer span, int t);

		Pointer span_period_to_tbox(Pointer span, Pointer p);

		Pointer tbox_to_floatspan(Pointer box);

		Pointer tbox_to_period(Pointer box);

		Pointer stbox_to_period(Pointer box);

		Pointer tnumber_to_tbox(Pointer temp);

		Pointer stbox_to_geo(Pointer box);

		Pointer tpoint_to_stbox(Pointer temp);

		Pointer geo_to_stbox(Pointer gs);

		Pointer timestamp_to_stbox(int t);

		Pointer timestampset_to_stbox(Pointer ts);

		Pointer period_to_stbox(Pointer p);

		Pointer periodset_to_stbox(Pointer ps);

		Pointer geo_timestamp_to_stbox(Pointer gs, int t);

		Pointer geo_period_to_stbox(Pointer gs, Pointer p);

		boolean tbox_hasx(Pointer box);

		boolean tbox_hast(Pointer box);

		boolean tbox_xmin(Pointer box, Pointer result);

		boolean tbox_xmax(Pointer box, Pointer result);

		boolean tbox_tmin(Pointer box, Pointer result);

		boolean tbox_tmax(Pointer box, Pointer result);

		boolean stbox_hasx(Pointer box);

		boolean stbox_hasz(Pointer box);

		boolean stbox_hast(Pointer box);

		boolean stbox_isgeodetic(Pointer box);

		boolean stbox_xmin(Pointer box, Pointer result);

		boolean stbox_xmax(Pointer box, Pointer result);

		boolean stbox_ymin(Pointer box, Pointer result);

		boolean stbox_ymax(Pointer box, Pointer result);

		boolean stbox_zmin(Pointer box, Pointer result);

		boolean stbox_zmax(Pointer box, Pointer result);

		boolean stbox_tmin(Pointer box, Pointer result);

		boolean stbox_tmax(Pointer box, Pointer result);

		int32_t stbox_srid(Pointer box);

		void tbox_expand(Pointer box1, Pointer box2);

		void tbox_shift_tscale(Pointer start, Pointer duration, Pointer box);

		Pointer tbox_expand_value(Pointer box, double d);

		Pointer tbox_expand_temporal(Pointer box, Pointer interval);

		void stbox_expand(Pointer box1, Pointer box2);

		void stbox_shift_tscale(Pointer start, Pointer duration, Pointer box);

		Pointer stbox_set_srid(Pointer box, int32_t srid);

		Pointer stbox_expand_spatial(Pointer box, double d);

		Pointer stbox_expand_temporal(Pointer box, Pointer interval);

		boolean contains_tbox_tbox(Pointer box1, Pointer box2);

		boolean contained_tbox_tbox(Pointer box1, Pointer box2);

		boolean overlaps_tbox_tbox(Pointer box1, Pointer box2);

		boolean same_tbox_tbox(Pointer box1, Pointer box2);

		boolean adjacent_tbox_tbox(Pointer box1, Pointer box2);

		boolean contains_stbox_stbox(Pointer box1, Pointer box2);

		boolean contained_stbox_stbox(Pointer box1, Pointer box2);

		boolean overlaps_stbox_stbox(Pointer box1, Pointer box2);

		boolean same_stbox_stbox(Pointer box1, Pointer box2);

		boolean adjacent_stbox_stbox(Pointer box1, Pointer box2);

		boolean left_tbox_tbox(Pointer box1, Pointer box2);

		boolean overleft_tbox_tbox(Pointer box1, Pointer box2);

		boolean right_tbox_tbox(Pointer box1, Pointer box2);

		boolean overright_tbox_tbox(Pointer box1, Pointer box2);

		boolean before_tbox_tbox(Pointer box1, Pointer box2);

		boolean overbefore_tbox_tbox(Pointer box1, Pointer box2);

		boolean after_tbox_tbox(Pointer box1, Pointer box2);

		boolean overafter_tbox_tbox(Pointer box1, Pointer box2);

		boolean left_stbox_stbox(Pointer box1, Pointer box2);

		boolean overleft_stbox_stbox(Pointer box1, Pointer box2);

		boolean right_stbox_stbox(Pointer box1, Pointer box2);

		boolean overright_stbox_stbox(Pointer box1, Pointer box2);

		boolean below_stbox_stbox(Pointer box1, Pointer box2);

		boolean overbelow_stbox_stbox(Pointer box1, Pointer box2);

		boolean above_stbox_stbox(Pointer box1, Pointer box2);

		boolean overabove_stbox_stbox(Pointer box1, Pointer box2);

		boolean front_stbox_stbox(Pointer box1, Pointer box2);

		boolean overfront_stbox_stbox(Pointer box1, Pointer box2);

		boolean back_stbox_stbox(Pointer box1, Pointer box2);

		boolean overback_stbox_stbox(Pointer box1, Pointer box2);

		boolean before_stbox_stbox(Pointer box1, Pointer box2);

		boolean overbefore_stbox_stbox(Pointer box1, Pointer box2);

		boolean after_stbox_stbox(Pointer box1, Pointer box2);

		boolean overafter_stbox_stbox(Pointer box1, Pointer box2);

		Pointer union_tbox_tbox(Pointer box1, Pointer box2);

		boolean inter_tbox_tbox(Pointer box1, Pointer box2, Pointer result);

		Pointer intersection_tbox_tbox(Pointer box1, Pointer box2);

		Pointer union_stbox_stbox(Pointer box1, Pointer box2, boolean strict);

		boolean inter_stbox_stbox(Pointer box1, Pointer box2, Pointer result);

		Pointer intersection_stbox_stbox(Pointer box1, Pointer box2);

		boolean tbox_eq(Pointer box1, Pointer box2);

		boolean tbox_ne(Pointer box1, Pointer box2);

		int tbox_cmp(Pointer box1, Pointer box2);

		boolean tbox_lt(Pointer box1, Pointer box2);

		boolean tbox_le(Pointer box1, Pointer box2);

		boolean tbox_ge(Pointer box1, Pointer box2);

		boolean tbox_gt(Pointer box1, Pointer box2);

		boolean stbox_eq(Pointer box1, Pointer box2);

		boolean stbox_ne(Pointer box1, Pointer box2);

		int stbox_cmp(Pointer box1, Pointer box2);

		boolean stbox_lt(Pointer box1, Pointer box2);

		boolean stbox_le(Pointer box1, Pointer box2);

		boolean stbox_ge(Pointer box1, Pointer box2);

		boolean stbox_gt(Pointer box1, Pointer box2);

		Pointer cstring2text(String cstring);

		String text2cstring(Pointer textptr);

		Pointer tbool_in(String str);

		String tbool_out(Pointer temp);

		String temporal_as_hexwkb(Pointer temp, u_int8_t variant, Pointer size_out);

		String temporal_as_mfjson(Pointer temp, boolean with_bbox, int flags, int precision, String srs);

		Pointer temporal_as_wkb(Pointer temp, u_int8_t variant, Pointer size_out);

		Pointer temporal_from_hexwkb(String hexwkb);

		Pointer temporal_from_mfjson(String mfjson);

		Pointer temporal_from_wkb(Pointer wkb, int size);

		Pointer tfloat_in(String str);

		String tfloat_out(Pointer temp, int maxdd);

		Pointer tgeogpoint_in(String str);

		Pointer tgeompoint_in(String str);

		Pointer tint_in(String str);

		String tint_out(Pointer temp);

		String tpoint_as_ewkt(Pointer temp, int maxdd);

		String tpoint_as_text(Pointer temp, int maxdd);

		String tpoint_out(Pointer temp, int maxdd);

		Pointer ttext_in(String str);

		String ttext_out(Pointer temp);

		Pointer tbool_from_base(boolean b, Pointer temp);

		Pointer tboolinst_make(boolean b, int t);

		Pointer tbooldiscseq_from_base_time(boolean b, Pointer ts);

		Pointer tboolseq_from_base(boolean b, Pointer seq);

		Pointer tboolseq_from_base_time(boolean b, Pointer p);

		Pointer tboolseqset_from_base(boolean b, Pointer ss);

		Pointer tboolseqset_from_base_time(boolean b, Pointer ps);

		Pointer temporal_copy(Pointer temp);

		Pointer tfloat_from_base(double d, Pointer temp, interpType interp);

		Pointer tfloatinst_make(double d, int t);

		Pointer tfloatdiscseq_from_base_time(double d, Pointer ts);

		Pointer tfloatseq_from_base(double d, Pointer seq, interpType interp);

		Pointer tfloatseq_from_base_time(double d, Pointer p, interpType interp);

		Pointer tfloatseqset_from_base(double d, Pointer ss, interpType interp);

		Pointer tfloatseqset_from_base_time(double d, Pointer ps, interpType interp);

		Pointer tgeogpoint_from_base(Pointer gs, Pointer temp, interpType interp);

		Pointer tgeogpointinst_make(Pointer gs, int t);

		Pointer tgeogpointdiscseq_from_base_time(Pointer gs, Pointer ts);

		Pointer tgeogpointseq_from_base(Pointer gs, Pointer seq, interpType interp);

		Pointer tgeogpointseq_from_base_time(Pointer gs, Pointer p, interpType interp);

		Pointer tgeogpointseqset_from_base(Pointer gs, Pointer ss, interpType interp);

		Pointer tgeogpointseqset_from_base_time(Pointer gs, Pointer ps, interpType interp);

		Pointer tgeompoint_from_base(Pointer gs, Pointer temp, interpType interp);

		Pointer tgeompointinst_make(Pointer gs, int t);

		Pointer tgeompointdiscseq_from_base_time(Pointer gs, Pointer ts);

		Pointer tgeompointseq_from_base(Pointer gs, Pointer seq, interpType interp);

		Pointer tgeompointseq_from_base_time(Pointer gs, Pointer p, interpType interp);

		Pointer tgeompointseqset_from_base(Pointer gs, Pointer ss, interpType interp);

		Pointer tgeompointseqset_from_base_time(Pointer gs, Pointer ps, interpType interp);

		Pointer tint_from_base(int i, Pointer temp);

		Pointer tintinst_make(int i, int t);

		Pointer tintdiscseq_from_base_time(int i, Pointer ts);

		Pointer tintseq_from_base(int i, Pointer seq);

		Pointer tintseq_from_base_time(int i, Pointer p);

		Pointer tintseqset_from_base(int i, Pointer ss);

		Pointer tintseqset_from_base_time(int i, Pointer ps);

		Pointer tsequence_make(Pointer[] instants, int count, boolean lower_inc, boolean upper_inc, interpType interp, boolean normalize);

		Pointer tsequence_make_exp(Pointer[] instants, int count, int maxcount, boolean lower_inc, boolean upper_inc, interpType interp, boolean normalize);

		Pointer tsequence_make_free(Pointer[] instants, int count, boolean lower_inc, boolean upper_inc, interpType interp, boolean normalize);

		Pointer tsequenceset_make(Pointer[] sequences, int count, boolean normalize);

		Pointer tsequenceset_make_free(Pointer[] sequences, int count, boolean normalize);

		Pointer tsequenceset_make_gaps(Pointer[] instants, int count, interpType interp, float maxdist, Pointer maxt);

		Pointer ttext_from_base(Pointer txt, Pointer temp);

		Pointer ttextinst_make(Pointer txt, int t);

		Pointer ttextdiscseq_from_base_time(Pointer txt, Pointer ts);

		Pointer ttextseq_from_base(Pointer txt, Pointer seq);

		Pointer ttextseq_from_base_time(Pointer txt, Pointer p);

		Pointer ttextseqset_from_base(Pointer txt, Pointer ss);

		Pointer ttextseqset_from_base_time(Pointer txt, Pointer ps);

		Pointer tfloat_to_tint(Pointer temp);

		Pointer tint_to_tfloat(Pointer temp);

		Pointer tnumber_to_span(Pointer temp);

		Pointer temporal_to_period(Pointer temp);

		boolean tbool_end_value(Pointer temp);

		boolean tbool_start_value(Pointer temp);

		Pointer tbool_values(Pointer temp, Pointer count);

		Pointer temporal_duration(Pointer temp);

		Pointer temporal_end_sequence(Pointer temp);

		int temporal_end_timestamp(Pointer temp);

		u_int32_t temporal_hash(Pointer temp);

		String temporal_interpolation(Pointer temp);

		int temporal_num_instants(Pointer temp);

		int temporal_num_sequences(Pointer temp);

		int temporal_num_timestamps(Pointer temp);

		Pointer[] temporal_segments(Pointer temp, Pointer count);

		Pointer temporal_sequence_n(Pointer temp, int i);

		Pointer[] temporal_sequences(Pointer temp, Pointer count);

		size_t temporal_size(Pointer temp);

		Pointer temporal_start_sequence(Pointer temp);

		int temporal_start_timestamp(Pointer temp);

		String temporal_subtype(Pointer temp);

		Pointer temporal_time(Pointer temp);

		Pointer temporal_timespan(Pointer temp);

		boolean temporal_timestamp_n(Pointer temp, int n, Pointer result);

		Pointer temporal_timestamps(Pointer temp, Pointer count);

		double tfloat_end_value(Pointer temp);

		double tfloat_max_value(Pointer temp);

		double tfloat_min_value(Pointer temp);

		Pointer[] tfloat_spans(Pointer temp, Pointer count);

		double tfloat_start_value(Pointer temp);

		Pointer tfloat_values(Pointer temp, Pointer count);

		int tint_end_value(Pointer temp);

		int tint_max_value(Pointer temp);

		int tint_min_value(Pointer temp);

		int tint_start_value(Pointer temp);

		Pointer tint_values(Pointer temp, Pointer count);

		Pointer tpoint_end_value(Pointer temp);

		Pointer tpoint_start_value(Pointer temp);

		Pointer[] tpoint_values(Pointer temp, Pointer count);

		Pointer ttext_end_value(Pointer temp);

		Pointer ttext_max_value(Pointer temp);

		Pointer ttext_min_value(Pointer temp);

		Pointer ttext_start_value(Pointer temp);

		Pointer[] ttext_values(Pointer temp, Pointer count);

		Pointer tsequence_compact(Pointer seq);

		Pointer temporal_append_tinstant(Pointer temp, Pointer inst, boolean expand);

		Pointer temporal_merge(Pointer temp1, Pointer temp2);

		Pointer temporal_merge_array(Pointer[] temparr, int count);

		Pointer temporal_shift(Pointer temp, Pointer shift);

		Pointer temporal_shift_tscale(Pointer temp, Pointer shift, Pointer duration);

		Pointer temporal_step_to_linear(Pointer temp);

		Pointer temporal_to_tinstant(Pointer temp);

		Pointer temporal_to_tdiscseq(Pointer temp);

		Pointer temporal_to_tsequence(Pointer temp);

		Pointer temporal_to_tsequenceset(Pointer temp);

		Pointer temporal_tscale(Pointer temp, Pointer duration);

		Pointer tbool_at_value(Pointer temp, boolean b);

		Pointer tbool_minus_value(Pointer temp, boolean b);

		boolean tbool_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer value);

		Pointer temporal_at_max(Pointer temp);

		Pointer temporal_at_min(Pointer temp);

		Pointer temporal_at_period(Pointer temp, Pointer p);

		Pointer temporal_at_periodset(Pointer temp, Pointer ps);

		Pointer temporal_at_timestamp(Pointer temp, int t);

		Pointer temporal_at_timestampset(Pointer temp, Pointer ts);

		Pointer temporal_minus_max(Pointer temp);

		Pointer temporal_minus_min(Pointer temp);

		Pointer temporal_minus_period(Pointer temp, Pointer p);

		Pointer temporal_minus_periodset(Pointer temp, Pointer ps);

		Pointer temporal_minus_timestamp(Pointer temp, int t);

		Pointer temporal_minus_timestampset(Pointer temp, Pointer ts);

		Pointer tfloat_at_value(Pointer temp, double d);

		Pointer tfloat_at_values(Pointer temp, Pointer values, int count);

		Pointer tfloat_minus_value(Pointer temp, double d);

		Pointer tfloat_minus_values(Pointer temp, Pointer values, int count);

		boolean tfloat_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer value);

		Pointer tint_at_value(Pointer temp, int i);

		Pointer tint_at_values(Pointer temp, Pointer values, int count);

		Pointer tint_minus_value(Pointer temp, int i);

		Pointer tint_minus_values(Pointer temp, Pointer values, int count);

		boolean tint_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer value);

		Pointer tnumber_at_span(Pointer temp, Pointer span);

		Pointer tnumber_at_spans(Pointer temp, Pointer[] spans, int count);

		Pointer tnumber_at_tbox(Pointer temp, Pointer box);

		Pointer tnumber_minus_span(Pointer temp, Pointer span);

		Pointer tnumber_minus_spans(Pointer temp, Pointer[] spans, int count);

		Pointer tnumber_minus_tbox(Pointer temp, Pointer box);

		Pointer tpoint_at_geometry(Pointer temp, Pointer gs);

		Pointer tpoint_at_stbox(Pointer temp, Pointer box);

		Pointer tpoint_at_value(Pointer temp, Pointer gs);

		Pointer tpoint_at_values(Pointer temp, Pointer[] values, int count);

		Pointer tpoint_minus_geometry(Pointer temp, Pointer gs);

		Pointer tpoint_minus_stbox(Pointer temp, Pointer box);

		Pointer tpoint_minus_value(Pointer temp, Pointer gs);

		Pointer tpoint_minus_values(Pointer temp, Pointer[] values, int count);

		boolean tpoint_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer[] value);

		Pointer ttext_at_value(Pointer temp, Pointer txt);

		Pointer ttext_at_values(Pointer temp, Pointer[] values, int count);

		Pointer ttext_minus_value(Pointer temp, Pointer txt);

		Pointer ttext_minus_values(Pointer temp, Pointer[] values, int count);

		boolean ttext_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer[] value);

		Pointer tand_bool_tbool(boolean b, Pointer temp);

		Pointer tand_tbool_bool(Pointer temp, boolean b);

		Pointer tand_tbool_tbool(Pointer temp1, Pointer temp2);

		Pointer tnot_tbool(Pointer temp);

		Pointer tor_bool_tbool(boolean b, Pointer temp);

		Pointer tor_tbool_bool(Pointer temp, boolean b);

		Pointer tor_tbool_tbool(Pointer temp1, Pointer temp2);

		Pointer tbool_when_true(Pointer temp);

		Pointer add_float_tfloat(double d, Pointer tnumber);

		Pointer add_int_tint(int i, Pointer tnumber);

		Pointer add_tfloat_float(Pointer tnumber, double d);

		Pointer add_tint_int(Pointer tnumber, int i);

		Pointer add_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		Pointer div_float_tfloat(double d, Pointer tnumber);

		Pointer div_int_tint(int i, Pointer tnumber);

		Pointer div_tfloat_float(Pointer tnumber, double d);

		Pointer div_tint_int(Pointer tnumber, int i);

		Pointer div_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		Pointer mult_float_tfloat(double d, Pointer tnumber);

		Pointer mult_int_tint(int i, Pointer tnumber);

		Pointer mult_tfloat_float(Pointer tnumber, double d);

		Pointer mult_tint_int(Pointer tnumber, int i);

		Pointer mult_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		Pointer sub_float_tfloat(double d, Pointer tnumber);

		Pointer sub_int_tint(int i, Pointer tnumber);

		Pointer sub_tfloat_float(Pointer tnumber, double d);

		Pointer sub_tint_int(Pointer tnumber, int i);

		Pointer sub_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		Pointer tfloat_degrees(Pointer temp);

		Pointer tfloat_radians(Pointer temp);

		Pointer tfloat_derivative(Pointer temp);

		Pointer textcat_text_ttext(Pointer txt, Pointer temp);

		Pointer textcat_ttext_text(Pointer temp, Pointer txt);

		Pointer textcat_ttext_ttext(Pointer temp1, Pointer temp2);

		Pointer ttext_upper(Pointer temp);

		Pointer ttext_lower(Pointer temp);

		boolean adjacent_float_tfloat(double d, Pointer tnumber);

		boolean adjacent_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean adjacent_int_tint(int i, Pointer tnumber);

		boolean adjacent_period_temporal(Pointer p, Pointer temp);

		boolean adjacent_periodset_temporal(Pointer ps, Pointer temp);

		boolean adjacent_span_tnumber(Pointer span, Pointer tnumber);

		boolean adjacent_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean adjacent_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean adjacent_temporal_period(Pointer temp, Pointer p);

		boolean adjacent_temporal_periodset(Pointer temp, Pointer ps);

		boolean adjacent_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean adjacent_temporal_timestamp(Pointer temp, int t);

		boolean adjacent_temporal_timestampset(Pointer temp, Pointer ts);

		boolean adjacent_tfloat_float(Pointer tnumber, double d);

		boolean adjacent_timestamp_temporal(int t, Pointer temp);

		boolean adjacent_timestampset_temporal(Pointer ts, Pointer temp);

		boolean adjacent_tint_int(Pointer tnumber, int i);

		boolean adjacent_tnumber_span(Pointer tnumber, Pointer span);

		boolean adjacent_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean adjacent_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean adjacent_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean adjacent_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean adjacent_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean contained_float_tfloat(double d, Pointer tnumber);

		boolean contained_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean contained_int_tint(int i, Pointer tnumber);

		boolean contained_period_temporal(Pointer p, Pointer temp);

		boolean contained_periodset_temporal(Pointer ps, Pointer temp);

		boolean contained_span_tnumber(Pointer span, Pointer tnumber);

		boolean contained_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean contained_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean contained_temporal_period(Pointer temp, Pointer p);

		boolean contained_temporal_periodset(Pointer temp, Pointer ps);

		boolean contained_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean contained_temporal_timestamp(Pointer temp, int t);

		boolean contained_temporal_timestampset(Pointer temp, Pointer ts);

		boolean contained_tfloat_float(Pointer tnumber, double d);

		boolean contained_timestamp_temporal(int t, Pointer temp);

		boolean contained_timestampset_temporal(Pointer ts, Pointer temp);

		boolean contained_tint_int(Pointer tnumber, int i);

		boolean contained_tnumber_span(Pointer tnumber, Pointer span);

		boolean contained_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean contained_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean contained_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean contained_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean contained_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean contains_bbox_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean contains_float_tfloat(double d, Pointer tnumber);

		boolean contains_int_tint(int i, Pointer tnumber);

		boolean contains_period_temporal(Pointer p, Pointer temp);

		boolean contains_periodset_temporal(Pointer ps, Pointer temp);

		boolean contains_span_tnumber(Pointer span, Pointer tnumber);

		boolean contains_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean contains_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean contains_temporal_period(Pointer temp, Pointer p);

		boolean contains_temporal_periodset(Pointer temp, Pointer ps);

		boolean contains_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean contains_temporal_timestamp(Pointer temp, int t);

		boolean contains_temporal_timestampset(Pointer temp, Pointer ts);

		boolean contains_tfloat_float(Pointer tnumber, double d);

		boolean contains_timestamp_temporal(int t, Pointer temp);

		boolean contains_timestampset_temporal(Pointer ts, Pointer temp);

		boolean contains_tint_int(Pointer tnumber, int i);

		boolean contains_tnumber_span(Pointer tnumber, Pointer span);

		boolean contains_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean contains_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean contains_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean contains_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean contains_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean left_float_tfloat(double d, Pointer tnumber);

		boolean left_int_tint(int i, Pointer tnumber);

		boolean left_tfloat_float(Pointer tnumber, double d);

		boolean left_tint_int(Pointer tnumber, int i);

		boolean overlaps_float_tfloat(double d, Pointer tnumber);

		boolean overlaps_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overlaps_int_tint(int i, Pointer tnumber);

		boolean overlaps_period_temporal(Pointer p, Pointer temp);

		boolean overlaps_periodset_temporal(Pointer ps, Pointer temp);

		boolean overlaps_span_tnumber(Pointer span, Pointer tnumber);

		boolean overlaps_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overlaps_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean overlaps_temporal_period(Pointer temp, Pointer p);

		boolean overlaps_temporal_periodset(Pointer temp, Pointer ps);

		boolean overlaps_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean overlaps_temporal_timestamp(Pointer temp, int t);

		boolean overlaps_temporal_timestampset(Pointer temp, Pointer ts);

		boolean overlaps_tfloat_float(Pointer tnumber, double d);

		boolean overlaps_timestamp_temporal(int t, Pointer temp);

		boolean overlaps_timestampset_temporal(Pointer ts, Pointer temp);

		boolean overlaps_tint_int(Pointer tnumber, int i);

		boolean overlaps_tnumber_span(Pointer tnumber, Pointer span);

		boolean overlaps_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean overlaps_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean overlaps_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overlaps_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overlaps_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overleft_float_tfloat(double d, Pointer tnumber);

		boolean overleft_int_tint(int i, Pointer tnumber);

		boolean overleft_tfloat_float(Pointer tnumber, double d);

		boolean overleft_tint_int(Pointer tnumber, int i);

		boolean overright_float_tfloat(double d, Pointer tnumber);

		boolean overright_int_tint(int i, Pointer tnumber);

		boolean overright_tfloat_float(Pointer tnumber, double d);

		boolean overright_tint_int(Pointer tnumber, int i);

		boolean right_float_tfloat(double d, Pointer tnumber);

		boolean right_int_tint(int i, Pointer tnumber);

		boolean right_tfloat_float(Pointer tnumber, double d);

		boolean right_tint_int(Pointer tnumber, int i);

		boolean same_float_tfloat(double d, Pointer tnumber);

		boolean same_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean same_int_tint(int i, Pointer tnumber);

		boolean same_period_temporal(Pointer p, Pointer temp);

		boolean same_periodset_temporal(Pointer ps, Pointer temp);

		boolean same_span_tnumber(Pointer span, Pointer tnumber);

		boolean same_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean same_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean same_temporal_period(Pointer temp, Pointer p);

		boolean same_temporal_periodset(Pointer temp, Pointer ps);

		boolean same_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean same_temporal_timestamp(Pointer temp, int t);

		boolean same_temporal_timestampset(Pointer temp, Pointer ts);

		boolean same_tfloat_float(Pointer tnumber, double d);

		boolean same_timestamp_temporal(int t, Pointer temp);

		boolean same_timestampset_temporal(Pointer ts, Pointer temp);

		boolean same_tint_int(Pointer tnumber, int i);

		boolean same_tnumber_span(Pointer tnumber, Pointer span);

		boolean same_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean same_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean same_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean same_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean same_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean above_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean above_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean above_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean above_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean above_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean after_period_temporal(Pointer p, Pointer temp);

		boolean after_periodset_temporal(Pointer ps, Pointer temp);

		boolean after_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean after_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean after_temporal_period(Pointer temp, Pointer p);

		boolean after_temporal_periodset(Pointer temp, Pointer ps);

		boolean after_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean after_temporal_timestamp(Pointer temp, int t);

		boolean after_temporal_timestampset(Pointer temp, Pointer ts);

		boolean after_timestamp_temporal(int t, Pointer temp);

		boolean after_timestampset_temporal(Pointer ts, Pointer temp);

		boolean after_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean after_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean after_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean after_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean back_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean back_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean back_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean back_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean back_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean before_period_temporal(Pointer p, Pointer temp);

		boolean before_periodset_temporal(Pointer ps, Pointer temp);

		boolean before_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean before_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean before_temporal_period(Pointer temp, Pointer p);

		boolean before_temporal_periodset(Pointer temp, Pointer ps);

		boolean before_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean before_temporal_timestamp(Pointer temp, int t);

		boolean before_temporal_timestampset(Pointer temp, Pointer ts);

		boolean before_timestamp_temporal(int t, Pointer temp);

		boolean before_timestampset_temporal(Pointer ts, Pointer temp);

		boolean before_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean before_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean before_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean before_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean below_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean below_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean below_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean below_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean below_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean front_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean front_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean front_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean front_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean front_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean left_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean left_span_tnumber(Pointer span, Pointer tnumber);

		boolean left_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean left_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean left_tnumber_span(Pointer tnumber, Pointer span);

		boolean left_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean left_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean left_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean left_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean left_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overabove_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overabove_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overabove_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overabove_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overabove_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overafter_period_temporal(Pointer p, Pointer temp);

		boolean overafter_periodset_temporal(Pointer ps, Pointer temp);

		boolean overafter_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overafter_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean overafter_temporal_period(Pointer temp, Pointer p);

		boolean overafter_temporal_periodset(Pointer temp, Pointer ps);

		boolean overafter_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean overafter_temporal_timestamp(Pointer temp, int t);

		boolean overafter_temporal_timestampset(Pointer temp, Pointer ts);

		boolean overafter_timestamp_temporal(int t, Pointer temp);

		boolean overafter_timestampset_temporal(Pointer ts, Pointer temp);

		boolean overafter_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean overafter_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean overafter_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overafter_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overback_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overback_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overback_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overback_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overback_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overbefore_period_temporal(Pointer p, Pointer temp);

		boolean overbefore_periodset_temporal(Pointer ps, Pointer temp);

		boolean overbefore_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overbefore_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean overbefore_temporal_period(Pointer temp, Pointer p);

		boolean overbefore_temporal_periodset(Pointer temp, Pointer ps);

		boolean overbefore_temporal_temporal(Pointer temp1, Pointer temp2);

		boolean overbefore_temporal_timestamp(Pointer temp, int t);

		boolean overbefore_temporal_timestampset(Pointer temp, Pointer ts);

		boolean overbefore_timestamp_temporal(int t, Pointer temp);

		boolean overbefore_timestampset_temporal(Pointer ts, Pointer temp);

		boolean overbefore_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean overbefore_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean overbefore_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overbefore_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overbelow_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overbelow_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overbelow_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overbelow_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overbelow_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overfront_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overfront_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overfront_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overfront_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overfront_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overleft_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overleft_span_tnumber(Pointer span, Pointer tnumber);

		boolean overleft_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overleft_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean overleft_tnumber_span(Pointer tnumber, Pointer span);

		boolean overleft_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean overleft_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean overleft_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overleft_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overleft_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean overright_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean overright_span_tnumber(Pointer span, Pointer tnumber);

		boolean overright_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean overright_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean overright_tnumber_span(Pointer tnumber, Pointer span);

		boolean overright_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean overright_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean overright_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean overright_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean overright_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		boolean right_geo_tpoint(Pointer geo, Pointer tpoint);

		boolean right_span_tnumber(Pointer span, Pointer tnumber);

		boolean right_stbox_tpoint(Pointer stbox, Pointer tpoint);

		boolean right_tbox_tnumber(Pointer tbox, Pointer tnumber);

		boolean right_tnumber_span(Pointer tnumber, Pointer span);

		boolean right_tnumber_tbox(Pointer tnumber, Pointer tbox);

		boolean right_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2);

		boolean right_tpoint_geo(Pointer tpoint, Pointer geo);

		boolean right_tpoint_stbox(Pointer tpoint, Pointer stbox);

		boolean right_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2);

		Pointer distance_tfloat_float(Pointer temp, double d);

		Pointer distance_tint_int(Pointer temp, int i);

		Pointer distance_tnumber_tnumber(Pointer temp1, Pointer temp2);

		Pointer distance_tpoint_geo(Pointer temp, Pointer geo);

		Pointer distance_tpoint_tpoint(Pointer temp1, Pointer temp2);

		double nad_stbox_geo(Pointer box, Pointer gs);

		double nad_stbox_stbox(Pointer box1, Pointer box2);

		double nad_tbox_tbox(Pointer box1, Pointer box2);

		double nad_tfloat_float(Pointer temp, double d);

		double nad_tfloat_tfloat(Pointer temp1, Pointer temp2);

		int nad_tint_int(Pointer temp, int i);

		int nad_tint_tint(Pointer temp1, Pointer temp2);

		double nad_tnumber_tbox(Pointer temp, Pointer box);

		double nad_tpoint_geo(Pointer temp, Pointer gs);

		double nad_tpoint_stbox(Pointer temp, Pointer box);

		double nad_tpoint_tpoint(Pointer temp1, Pointer temp2);

		Pointer nai_tpoint_geo(Pointer temp, Pointer gs);

		Pointer nai_tpoint_tpoint(Pointer temp1, Pointer temp2);

		boolean shortestline_tpoint_geo(Pointer temp, Pointer gs, Pointer[] result);

		boolean shortestline_tpoint_tpoint(Pointer temp1, Pointer temp2, Pointer[] result);

		boolean tbool_always_eq(Pointer temp, boolean b);

		boolean tbool_ever_eq(Pointer temp, boolean b);

		boolean tfloat_always_eq(Pointer temp, double d);

		boolean tfloat_always_le(Pointer temp, double d);

		boolean tfloat_always_lt(Pointer temp, double d);

		boolean tfloat_ever_eq(Pointer temp, double d);

		boolean tfloat_ever_le(Pointer temp, double d);

		boolean tfloat_ever_lt(Pointer temp, double d);

		boolean tgeogpoint_always_eq(Pointer temp, Pointer gs);

		boolean tgeogpoint_ever_eq(Pointer temp, Pointer gs);

		boolean tgeompoint_always_eq(Pointer temp, Pointer gs);

		boolean tgeompoint_ever_eq(Pointer temp, Pointer gs);

		boolean tint_always_eq(Pointer temp, int i);

		boolean tint_always_le(Pointer temp, int i);

		boolean tint_always_lt(Pointer temp, int i);

		boolean tint_ever_eq(Pointer temp, int i);

		boolean tint_ever_le(Pointer temp, int i);

		boolean tint_ever_lt(Pointer temp, int i);

		boolean ttext_always_eq(Pointer temp, Pointer txt);

		boolean ttext_always_le(Pointer temp, Pointer txt);

		boolean ttext_always_lt(Pointer temp, Pointer txt);

		boolean ttext_ever_eq(Pointer temp, Pointer txt);

		boolean ttext_ever_le(Pointer temp, Pointer txt);

		boolean ttext_ever_lt(Pointer temp, Pointer txt);

		int temporal_cmp(Pointer temp1, Pointer temp2);

		boolean temporal_eq(Pointer temp1, Pointer temp2);

		boolean temporal_ge(Pointer temp1, Pointer temp2);

		boolean temporal_gt(Pointer temp1, Pointer temp2);

		boolean temporal_le(Pointer temp1, Pointer temp2);

		boolean temporal_lt(Pointer temp1, Pointer temp2);

		boolean temporal_ne(Pointer temp1, Pointer temp2);

		Pointer teq_bool_tbool(boolean b, Pointer temp);

		Pointer teq_float_tfloat(double d, Pointer temp);

		Pointer teq_geo_tpoint(Pointer geo, Pointer tpoint);

		Pointer teq_int_tint(int i, Pointer temp);

		Pointer teq_point_tgeogpoint(Pointer gs, Pointer temp);

		Pointer teq_point_tgeompoint(Pointer gs, Pointer temp);

		Pointer teq_tbool_bool(Pointer temp, boolean b);

		Pointer teq_temporal_temporal(Pointer temp1, Pointer temp2);

		Pointer teq_text_ttext(Pointer txt, Pointer temp);

		Pointer teq_tfloat_float(Pointer temp, double d);

		Pointer teq_tgeogpoint_point(Pointer temp, Pointer gs);

		Pointer teq_tgeompoint_point(Pointer temp, Pointer gs);

		Pointer teq_tint_int(Pointer temp, int i);

		Pointer teq_tpoint_geo(Pointer tpoint, Pointer geo);

		Pointer teq_ttext_text(Pointer temp, Pointer txt);

		Pointer tge_float_tfloat(double d, Pointer temp);

		Pointer tge_int_tint(int i, Pointer temp);

		Pointer tge_temporal_temporal(Pointer temp1, Pointer temp2);

		Pointer tge_text_ttext(Pointer txt, Pointer temp);

		Pointer tge_tfloat_float(Pointer temp, double d);

		Pointer tge_tint_int(Pointer temp, int i);

		Pointer tge_ttext_text(Pointer temp, Pointer txt);

		Pointer tgt_float_tfloat(double d, Pointer temp);

		Pointer tgt_int_tint(int i, Pointer temp);

		Pointer tgt_temporal_temporal(Pointer temp1, Pointer temp2);

		Pointer tgt_text_ttext(Pointer txt, Pointer temp);

		Pointer tgt_tfloat_float(Pointer temp, double d);

		Pointer tgt_tint_int(Pointer temp, int i);

		Pointer tgt_ttext_text(Pointer temp, Pointer txt);

		Pointer tle_float_tfloat(double d, Pointer temp);

		Pointer tle_int_tint(int i, Pointer temp);

		Pointer tle_temporal_temporal(Pointer temp1, Pointer temp2);

		Pointer tle_text_ttext(Pointer txt, Pointer temp);

		Pointer tle_tfloat_float(Pointer temp, double d);

		Pointer tle_tint_int(Pointer temp, int i);

		Pointer tle_ttext_text(Pointer temp, Pointer txt);

		Pointer tlt_float_tfloat(double d, Pointer temp);

		Pointer tlt_int_tint(int i, Pointer temp);

		Pointer tlt_temporal_temporal(Pointer temp1, Pointer temp2);

		Pointer tlt_text_ttext(Pointer txt, Pointer temp);

		Pointer tlt_tfloat_float(Pointer temp, double d);

		Pointer tlt_tint_int(Pointer temp, int i);

		Pointer tlt_ttext_text(Pointer temp, Pointer txt);

		Pointer tne_bool_tbool(boolean b, Pointer temp);

		Pointer tne_float_tfloat(double d, Pointer temp);

		Pointer tne_geo_tpoint(Pointer geo, Pointer tpoint);

		Pointer tne_int_tint(int i, Pointer temp);

		Pointer tne_point_tgeogpoint(Pointer gs, Pointer temp);

		Pointer tne_point_tgeompoint(Pointer gs, Pointer temp);

		Pointer tne_tbool_bool(Pointer temp, boolean b);

		Pointer tne_temporal_temporal(Pointer temp1, Pointer temp2);

		Pointer tne_text_ttext(Pointer txt, Pointer temp);

		Pointer tne_tfloat_float(Pointer temp, double d);

		Pointer tne_tgeogpoint_point(Pointer temp, Pointer gs);

		Pointer tne_tgeompoint_point(Pointer temp, Pointer gs);

		Pointer tne_tint_int(Pointer temp, int i);

		Pointer tne_tpoint_geo(Pointer tpoint, Pointer geo);

		Pointer tne_ttext_text(Pointer temp, Pointer txt);

		boolean bearing_point_point(Pointer geo1, Pointer geo2, Pointer result);

		Pointer bearing_tpoint_point(Pointer temp, Pointer gs, boolean invert);

		Pointer bearing_tpoint_tpoint(Pointer temp1, Pointer temp2);

		Pointer tpoint_azimuth(Pointer temp);

		Pointer tpoint_cumulative_length(Pointer temp);

		Pointer tpoint_get_coord(Pointer temp, int coord);

		boolean tpoint_is_simple(Pointer temp);

		double tpoint_length(Pointer temp);

		Pointer tpoint_speed(Pointer temp);

		int tpoint_srid(Pointer temp);

		Pointer tpoint_stboxes(Pointer temp, Pointer count);

		Pointer tpoint_trajectory(Pointer temp);

		Pointer geo_expand_spatial(Pointer gs, double d);

		Pointer tgeompoint_tgeogpoint(Pointer temp, boolean oper);

		Pointer tpoint_expand_spatial(Pointer temp, double d);

		Pointer[] tpoint_make_simple(Pointer temp, Pointer count);

		Pointer tpoint_set_srid(Pointer temp, int32_t srid);

		int contains_geo_tpoint(Pointer geo, Pointer temp);

		int disjoint_tpoint_geo(Pointer temp, Pointer gs);

		int disjoint_tpoint_tpoint(Pointer temp1, Pointer temp2);

		int dwithin_tpoint_geo(Pointer temp, Pointer gs, double dist);

		int dwithin_tpoint_tpoint(Pointer temp1, Pointer temp2, double dist);

		int intersects_tpoint_geo(Pointer temp, Pointer gs);

		int intersects_tpoint_tpoint(Pointer temp1, Pointer temp2);

		Pointer tcontains_geo_tpoint(Pointer gs, Pointer temp, boolean restr, boolean atvalue);

		Pointer tdisjoint_tpoint_geo(Pointer temp, Pointer geo, boolean restr, boolean atvalue);

		Pointer tdwithin_tpoint_geo(Pointer temp, Pointer gs, double dist, boolean restr, boolean atvalue);

		Pointer tdwithin_tpoint_tpoint(Pointer temp1, Pointer temp2, double dist, boolean restr, boolean atvalue);

		Pointer tintersects_tpoint_geo(Pointer temp, Pointer geo, boolean restr, boolean atvalue);

		int touches_tpoint_geo(Pointer temp, Pointer gs);

		Pointer ttouches_tpoint_geo(Pointer temp, Pointer gs, boolean restr, boolean atvalue);

		Pointer temporal_insert(Pointer temp1, Pointer temp2, boolean connect);

		Pointer temporal_update(Pointer temp1, Pointer temp2, boolean connect);

		Pointer temporal_delete_timestamp(Pointer temp, int t, boolean connect);

		Pointer temporal_delete_timestampset(Pointer temp, Pointer ts, boolean connect);

		Pointer temporal_delete_period(Pointer temp, Pointer p, boolean connect);

		Pointer temporal_delete_periodset(Pointer temp, Pointer ps, boolean connect);

		boolean temporal_intersects_period(Pointer temp, Pointer p);

		boolean temporal_intersects_periodset(Pointer temp, Pointer ps);

		boolean temporal_intersects_timestamp(Pointer temp, int t);

		boolean temporal_intersects_timestampset(Pointer temp, Pointer ss);

		double tnumber_integral(Pointer temp);

		double tnumber_twavg(Pointer temp);

		Pointer tpoint_twcentroid(Pointer temp);

		void skiplist_free(Pointer list);

		Pointer temporal_extent_transfn(Pointer p, Pointer temp);

		Pointer tnumber_extent_transfn(Pointer box, Pointer temp);

		Pointer tpoint_extent_transfn(Pointer box, Pointer temp);

		Pointer temporal_tcount_transfn(Pointer state, Pointer temp, Pointer interval, int origin);

		Pointer tbool_tand_transfn(Pointer state, Pointer temp);

		Pointer tbool_tor_transfn(Pointer state, Pointer temp);

		Pointer tint_tmin_transfn(Pointer state, Pointer temp);

		Pointer tfloat_tmin_transfn(Pointer state, Pointer temp);

		Pointer tint_tmax_transfn(Pointer state, Pointer temp);

		Pointer tfloat_tmax_transfn(Pointer state, Pointer temp);

		Pointer tint_tsum_transfn(Pointer state, Pointer temp);

		Pointer tfloat_tsum_transfn(Pointer state, Pointer temp);

		Pointer tnumber_tavg_transfn(Pointer state, Pointer temp);

		Pointer ttext_tmin_transfn(Pointer state, Pointer temp);

		Pointer ttext_tmax_transfn(Pointer state, Pointer temp);

		Pointer temporal_tagg_finalfn(Pointer state);

		Pointer tnumber_tavg_finalfn(Pointer state);

		int int_bucket(int value, int size, int origin);

		double float_bucket(double value, double size, double origin);

		int timestamptz_bucket(int timestamp, Pointer duration, int origin);

		Pointer intspan_bucket_list(Pointer bounds, int size, int origin, Pointer newcount);

		Pointer floatspan_bucket_list(Pointer bounds, double size, double origin, Pointer newcount);

		Pointer period_bucket_list(Pointer bounds, Pointer duration, int origin, Pointer newcount);

		Pointer tbox_tile_list(Pointer bounds, double xsize, Pointer duration, double xorigin, int torigin, Pointer rows, Pointer columns);

		Pointer[] tint_value_split(Pointer temp, int size, int origin, Pointer newcount);

		Pointer[] tfloat_value_split(Pointer temp, double size, double origin, Pointer newcount);

		Pointer[] temporal_time_split(Pointer temp, Pointer duration, int torigin, Pointer newcount);

		Pointer[] tint_value_time_split(Pointer temp, int size, int vorigin, Pointer duration, int torigin, Pointer newcount);

		Pointer[] tfloat_value_time_split(Pointer temp, double size, double vorigin, Pointer duration, int torigin, Pointer newcount);

		Pointer stbox_tile_list(Pointer bounds, double size, Pointer duration, Pointer sorigin, int torigin, Pointer[] cellcount);

		double temporal_frechet_distance(Pointer temp1, Pointer temp2);

		double temporal_dyntimewarp_distance(Pointer temp1, Pointer temp2);

		Pointer temporal_frechet_path(Pointer temp1, Pointer temp2, Pointer count);

		Pointer temporal_dyntimewarp_path(Pointer temp1, Pointer temp2, Pointer count);

		Pointer geo_to_tpoint(Pointer geo);

		Pointer temporal_simplify(Pointer temp, double eps_dist, boolean synchronize);

		boolean tpoint_to_geo_measure(Pointer tpoint, Pointer measure, boolean segmentize, Pointer[] result);

	}

	public static Pointer lwpoint_make(int32_t srid, int hasz, int hasm, Pointer p) {
		return MeosLibrary.meos.lwpoint_make(srid, hasz, hasm, p);
	}
	
	public static Pointer lwgeom_from_gserialized(Pointer g) {
		return MeosLibrary.meos.lwgeom_from_gserialized(g);
	}
	
	public static Pointer gserialized_from_lwgeom(Pointer geom, Pointer size) {
		return MeosLibrary.meos.gserialized_from_lwgeom(geom, size);
	}
	
	public static Pointer lwgeom_as_lwpoint(Pointer lwgeom) {
		return MeosLibrary.meos.lwgeom_as_lwpoint(lwgeom);
	}
	
	public static int32_t lwgeom_get_srid(Pointer geom) {
		return MeosLibrary.meos.lwgeom_get_srid(geom);
	}
	
	public static double lwpoint_get_x(Pointer point) {
		return MeosLibrary.meos.lwpoint_get_x(point);
	}
	
	public static double lwpoint_get_y(Pointer point) {
		return MeosLibrary.meos.lwpoint_get_y(point);
	}
	
	public static double lwpoint_get_z(Pointer point) {
		return MeosLibrary.meos.lwpoint_get_z(point);
	}
	
	public static double lwpoint_get_m(Pointer point) {
		return MeosLibrary.meos.lwpoint_get_m(point);
	}
	
	public static int lwgeom_has_z(Pointer geom) {
		return MeosLibrary.meos.lwgeom_has_z(geom);
	}
	
	public static int lwgeom_has_m(Pointer geom) {
		return MeosLibrary.meos.lwgeom_has_m(geom);
	}
	
	public static void meos_initialize(byte[] tz_str) {
		MeosLibrary.meos.meos_initialize(tz_str);
	}
	
	public static void meos_finish() {
		MeosLibrary.meos.meos_finish();
	}
	
	public static boolean bool_in(String in_str) {
		return MeosLibrary.meos.bool_in(in_str);
	}
	
	public static String bool_out(boolean b) {
		return MeosLibrary.meos.bool_out(b);
	}
	
	public static DateADT pg_date_in(String str) {
		return MeosLibrary.meos.pg_date_in(str);
	}
	
	public static String pg_date_out(DateADT date) {
		return MeosLibrary.meos.pg_date_out(date);
	}
	
	public static int pg_interval_cmp(Pointer interval1, Pointer interval2) {
		return MeosLibrary.meos.pg_interval_cmp(interval1, interval2);
	}
	
	public static Pointer pg_interval_in(String str, int32_t typmod) {
		return MeosLibrary.meos.pg_interval_in(str, typmod);
	}
	
	public static Pointer pg_interval_make(int32_t years, int32_t months, int32_t weeks, int32_t days, int32_t hours, int32_t mins, double secs) {
		return MeosLibrary.meos.pg_interval_make(years, months, weeks, days, hours, mins, secs);
	}
	
	public static String pg_interval_out(Pointer span) {
		return MeosLibrary.meos.pg_interval_out(span);
	}
	
	public static Pointer pg_interval_mul(Pointer span, double factor) {
		return MeosLibrary.meos.pg_interval_mul(span, factor);
	}
	
	public static Pointer pg_interval_pl(Pointer span1, Pointer span2) {
		return MeosLibrary.meos.pg_interval_pl(span1, span2);
	}
	
	public static TimeADT pg_time_in(String str, int32_t typmod) {
		return MeosLibrary.meos.pg_time_in(str, typmod);
	}
	
	public static String pg_time_out(TimeADT time) {
		return MeosLibrary.meos.pg_time_out(time);
	}
	
	public static int pg_timestamp_in(String str, int32_t typmod) {
		return MeosLibrary.meos.pg_timestamp_in(str, typmod);
	}
	
	public static Pointer pg_timestamp_mi(int dt1, int dt2) {
		return MeosLibrary.meos.pg_timestamp_mi(dt1, dt2);
	}
	
	public static int pg_timestamp_mi_interval(int timestamp, Pointer span) {
		return MeosLibrary.meos.pg_timestamp_mi_interval(timestamp, span);
	}
	
	public static String pg_timestamp_out(int dt) {
		return MeosLibrary.meos.pg_timestamp_out(dt);
	}
	
	public static int pg_timestamp_pl_interval(int timestamp, Pointer span) {
		return MeosLibrary.meos.pg_timestamp_pl_interval(timestamp, span);
	}
	
	public static int pg_timestamptz_in(String str, int32_t typmod) {
		return MeosLibrary.meos.pg_timestamptz_in(str, typmod);
	}
	
	public static String pg_timestamptz_out(int dt) {
		return MeosLibrary.meos.pg_timestamptz_out(dt);
	}
	
	public static Pointer gserialized_as_ewkb(Pointer geom, String type) {
		return MeosLibrary.meos.gserialized_as_ewkb(geom, type);
	}
	
	public static String gserialized_as_geojson(Pointer geom, int option, int precision, String srs) {
		return MeosLibrary.meos.gserialized_as_geojson(geom, option, precision, srs);
	}
	
	public static String gserialized_as_hexewkb(Pointer geom, String type) {
		return MeosLibrary.meos.gserialized_as_hexewkb(geom, type);
	}
	
	public static String gserialized_as_text(Pointer geom, int precision) {
		return MeosLibrary.meos.gserialized_as_text(geom, precision);
	}
	
	public static Pointer gserialized_from_ewkb(Pointer bytea_wkb, int32_t srid) {
		return MeosLibrary.meos.gserialized_from_ewkb(bytea_wkb, srid);
	}
	
	public static Pointer gserialized_from_geojson(String geojson) {
		return MeosLibrary.meos.gserialized_from_geojson(geojson);
	}
	
	public static Pointer gserialized_from_hexewkb(String wkt) {
		return MeosLibrary.meos.gserialized_from_hexewkb(wkt);
	}
	
	public static Pointer gserialized_from_text(String wkt, int srid) {
		return MeosLibrary.meos.gserialized_from_text(wkt, srid);
	}
	
	public static Pointer gserialized_in(String input, int32_t geom_typmod) {
		return MeosLibrary.meos.gserialized_in(input, geom_typmod);
	}
	
	public static String gserialized_out(Pointer geom) {
		return MeosLibrary.meos.gserialized_out(geom);
	}
	
	public static boolean gserialized_same(Pointer geom1, Pointer geom2) {
		return MeosLibrary.meos.gserialized_same(geom1, geom2);
	}
	
	public static Pointer floatspan_in(String str) {
		return MeosLibrary.meos.floatspan_in(str);
	}
	
	public static String floatspan_out(Pointer s, int maxdd) {
		return MeosLibrary.meos.floatspan_out(s, maxdd);
	}
	
	public static Pointer intspan_in(String str) {
		return MeosLibrary.meos.intspan_in(str);
	}
	
	public static String intspan_out(Pointer s) {
		return MeosLibrary.meos.intspan_out(s);
	}
	
	public static Pointer period_in(String str) {
		return MeosLibrary.meos.period_in(str);
	}
	
	public static String period_out(Pointer s) {
		return MeosLibrary.meos.period_out(s);
	}
	
	public static String periodset_as_hexwkb(Pointer ps, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.periodset_as_hexwkb(ps, variant, size_out);
	}
	
	public static Pointer periodset_as_wkb(Pointer ps, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.periodset_as_wkb(ps, variant, size_out);
	}
	
	public static Pointer periodset_from_hexwkb(String hexwkb) {
		return MeosLibrary.meos.periodset_from_hexwkb(hexwkb);
	}
	
	public static Pointer periodset_from_wkb(Pointer wkb, int size) {
		return MeosLibrary.meos.periodset_from_wkb(wkb, size);
	}
	
	public static Pointer periodset_in(String str) {
		return MeosLibrary.meos.periodset_in(str);
	}
	
	public static String periodset_out(Pointer ps) {
		return MeosLibrary.meos.periodset_out(ps);
	}
	
	public static String span_as_hexwkb(Pointer s, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.span_as_hexwkb(s, variant, size_out);
	}
	
	public static Pointer span_as_wkb(Pointer s, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.span_as_wkb(s, variant, size_out);
	}
	
	public static Pointer span_from_hexwkb(String hexwkb) {
		return MeosLibrary.meos.span_from_hexwkb(hexwkb);
	}
	
	public static Pointer span_from_wkb(Pointer wkb, int size) {
		return MeosLibrary.meos.span_from_wkb(wkb, size);
	}
	
	public static String span_out(Pointer s, int arg) {
		return MeosLibrary.meos.span_out(s, arg);
	}
	
	public static String timestampset_as_hexwkb(Pointer ts, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.timestampset_as_hexwkb(ts, variant, size_out);
	}
	
	public static Pointer timestampset_as_wkb(Pointer ts, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.timestampset_as_wkb(ts, variant, size_out);
	}
	
	public static Pointer timestampset_from_hexwkb(String hexwkb) {
		return MeosLibrary.meos.timestampset_from_hexwkb(hexwkb);
	}
	
	public static Pointer timestampset_from_wkb(Pointer wkb, int size) {
		return MeosLibrary.meos.timestampset_from_wkb(wkb, size);
	}
	
	public static Pointer timestampset_in(String str) {
		return MeosLibrary.meos.timestampset_in(str);
	}
	
	public static String timestampset_out(Pointer ts) {
		return MeosLibrary.meos.timestampset_out(ts);
	}
	
	public static Pointer floatspan_make(double lower, double upper, boolean lower_inc, boolean upper_inc) {
		return MeosLibrary.meos.floatspan_make(lower, upper, lower_inc, upper_inc);
	}
	
	public static Pointer intspan_make(int lower, int upper, boolean lower_inc, boolean upper_inc) {
		return MeosLibrary.meos.intspan_make(lower, upper, lower_inc, upper_inc);
	}
	
	public static Pointer period_make(int lower, int upper, boolean lower_inc, boolean upper_inc) {
		return MeosLibrary.meos.period_make(lower, upper, lower_inc, upper_inc);
	}
	
	public static Pointer periodset_copy(Pointer ps) {
		return MeosLibrary.meos.periodset_copy(ps);
	}
	
	public static Pointer periodset_make(Pointer[] periods, int count, boolean normalize) {
		return MeosLibrary.meos.periodset_make(periods, count, normalize);
	}
	
	public static Pointer periodset_make_free(Pointer[] periods, int count, boolean normalize) {
		return MeosLibrary.meos.periodset_make_free(periods, count, normalize);
	}
	
	public static Pointer span_copy(Pointer s) {
		return MeosLibrary.meos.span_copy(s);
	}
	
	public static Pointer timestampset_copy(Pointer ts) {
		return MeosLibrary.meos.timestampset_copy(ts);
	}
	
	public static Pointer timestampset_make(Pointer times, int count) {
		return MeosLibrary.meos.timestampset_make(times, count);
	}
	
	public static Pointer timestampset_make_free(Pointer times, int count) {
		return MeosLibrary.meos.timestampset_make_free(times, count);
	}
	
	public static Pointer float_to_floaspan(double d) {
		return MeosLibrary.meos.float_to_floaspan(d);
	}
	
	public static Pointer int_to_intspan(int i) {
		return MeosLibrary.meos.int_to_intspan(i);
	}
	
	public static Pointer period_to_periodset(Pointer period) {
		return MeosLibrary.meos.period_to_periodset(period);
	}
	
	public static Pointer periodset_to_period(Pointer ps) {
		return MeosLibrary.meos.periodset_to_period(ps);
	}
	
	public static Pointer timestamp_to_period(int t) {
		return MeosLibrary.meos.timestamp_to_period(t);
	}
	
	public static Pointer timestamp_to_periodset(int t) {
		return MeosLibrary.meos.timestamp_to_periodset(t);
	}
	
	public static Pointer timestamp_to_timestampset(int t) {
		return MeosLibrary.meos.timestamp_to_timestampset(t);
	}
	
	public static Pointer timestampset_to_periodset(Pointer ts) {
		return MeosLibrary.meos.timestampset_to_periodset(ts);
	}
	
	public static double floatspan_lower(Pointer s) {
		return MeosLibrary.meos.floatspan_lower(s);
	}
	
	public static double floatspan_upper(Pointer s) {
		return MeosLibrary.meos.floatspan_upper(s);
	}
	
	public static int intspan_lower(Pointer s) {
		return MeosLibrary.meos.intspan_lower(s);
	}
	
	public static int intspan_upper(Pointer s) {
		return MeosLibrary.meos.intspan_upper(s);
	}
	
	public static Pointer period_duration(Pointer s) {
		return MeosLibrary.meos.period_duration(s);
	}
	
	public static int period_lower(Pointer p) {
		return MeosLibrary.meos.period_lower(p);
	}
	
	public static int period_upper(Pointer p) {
		return MeosLibrary.meos.period_upper(p);
	}
	
	public static Pointer periodset_duration(Pointer ps) {
		return MeosLibrary.meos.periodset_duration(ps);
	}
	
	public static Pointer periodset_end_period(Pointer ps) {
		return MeosLibrary.meos.periodset_end_period(ps);
	}
	
	public static int periodset_end_timestamp(Pointer ps) {
		return MeosLibrary.meos.periodset_end_timestamp(ps);
	}
	
	public static u_int32_t periodset_hash(Pointer ps) {
		return MeosLibrary.meos.periodset_hash(ps);
	}
	
	public static u_int64_t periodset_hash_extended(Pointer ps, u_int64_t seed) {
		return MeosLibrary.meos.periodset_hash_extended(ps, seed);
	}
	
	public static int periodset_mem_size(Pointer ps) {
		return MeosLibrary.meos.periodset_mem_size(ps);
	}
	
	public static int periodset_num_periods(Pointer ps) {
		return MeosLibrary.meos.periodset_num_periods(ps);
	}
	
	public static int periodset_num_timestamps(Pointer ps) {
		return MeosLibrary.meos.periodset_num_timestamps(ps);
	}
	
	public static Pointer periodset_period_n(Pointer ps, int i) {
		return MeosLibrary.meos.periodset_period_n(ps, i);
	}
	
	public static Pointer periodset_start_period(Pointer ps) {
		return MeosLibrary.meos.periodset_start_period(ps);
	}
	
	public static int periodset_start_timestamp(Pointer ps) {
		return MeosLibrary.meos.periodset_start_timestamp(ps);
	}
	
	public static Pointer periodset_timespan(Pointer ps) {
		return MeosLibrary.meos.periodset_timespan(ps);
	}
	
	public static boolean periodset_timestamp_n(Pointer ps, int n, Pointer result) {
		return MeosLibrary.meos.periodset_timestamp_n(ps, n, result);
	}
	
	public static Pointer periodset_timestamps(Pointer ps, Pointer count) {
		return MeosLibrary.meos.periodset_timestamps(ps, count);
	}
	
	public static u_int32_t span_hash(Pointer s) {
		return MeosLibrary.meos.span_hash(s);
	}
	
	public static u_int64_t span_hash_extended(Pointer s, u_int64_t seed) {
		return MeosLibrary.meos.span_hash_extended(s, seed);
	}
	
	public static boolean span_lower_inc(Pointer s) {
		return MeosLibrary.meos.span_lower_inc(s);
	}
	
	public static boolean span_upper_inc(Pointer s) {
		return MeosLibrary.meos.span_upper_inc(s);
	}
	
	public static double span_width(Pointer s) {
		return MeosLibrary.meos.span_width(s);
	}
	
	public static int timestampset_end_timestamp(Pointer ss) {
		return MeosLibrary.meos.timestampset_end_timestamp(ss);
	}
	
	public static u_int32_t timestampset_hash(Pointer ss) {
		return MeosLibrary.meos.timestampset_hash(ss);
	}
	
	public static u_int64_t timestampset_hash_extended(Pointer ss, u_int64_t seed) {
		return MeosLibrary.meos.timestampset_hash_extended(ss, seed);
	}
	
	public static int timestampset_mem_size(Pointer ss) {
		return MeosLibrary.meos.timestampset_mem_size(ss);
	}
	
	public static int timestampset_num_timestamps(Pointer ss) {
		return MeosLibrary.meos.timestampset_num_timestamps(ss);
	}
	
	public static int timestampset_start_timestamp(Pointer ss) {
		return MeosLibrary.meos.timestampset_start_timestamp(ss);
	}
	
	public static Pointer timestampset_timespan(Pointer ss) {
		return MeosLibrary.meos.timestampset_timespan(ss);
	}
	
	public static boolean timestampset_timestamp_n(Pointer ss, int n, Pointer result) {
		return MeosLibrary.meos.timestampset_timestamp_n(ss, n, result);
	}
	
	public static Pointer timestampset_timestamps(Pointer ss) {
		return MeosLibrary.meos.timestampset_timestamps(ss);
	}
	
	public static Pointer periodset_shift_tscale(Pointer ps, Pointer start, Pointer duration) {
		return MeosLibrary.meos.periodset_shift_tscale(ps, start, duration);
	}
	
	public static void span_expand(Pointer s1, Pointer s2) {
		MeosLibrary.meos.span_expand(s1, s2);
	}
	
	public static void period_shift_tscale(Pointer start, Pointer duration, Pointer result) {
		MeosLibrary.meos.period_shift_tscale(start, duration, result);
	}
	
	public static Pointer timestampset_shift_tscale(Pointer ss, Pointer start, Pointer duration) {
		return MeosLibrary.meos.timestampset_shift_tscale(ss, start, duration);
	}
	
	public static boolean adjacent_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.adjacent_floatspan_float(s, d);
	}
	
	public static boolean adjacent_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.adjacent_intspan_int(s, i);
	}
	
	public static boolean adjacent_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.adjacent_period_periodset(p, ps);
	}
	
	public static boolean adjacent_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.adjacent_period_timestamp(p, t);
	}
	
	public static boolean adjacent_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.adjacent_period_timestampset(p, ts);
	}
	
	public static boolean adjacent_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.adjacent_periodset_period(ps, p);
	}
	
	public static boolean adjacent_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.adjacent_periodset_periodset(ps1, ps2);
	}
	
	public static boolean adjacent_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.adjacent_periodset_timestamp(ps, t);
	}
	
	public static boolean adjacent_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.adjacent_periodset_timestampset(ps, ts);
	}
	
	public static boolean adjacent_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.adjacent_span_span(s1, s2);
	}
	
	public static boolean adjacent_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.adjacent_timestamp_period(t, p);
	}
	
	public static boolean adjacent_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.adjacent_timestamp_periodset(t, ps);
	}
	
	public static boolean adjacent_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.adjacent_timestampset_period(ts, p);
	}
	
	public static boolean adjacent_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.adjacent_timestampset_periodset(ts, ps);
	}
	
	public static boolean contained_float_floatspan(double d, Pointer s) {
		return MeosLibrary.meos.contained_float_floatspan(d, s);
	}
	
	public static boolean contained_int_intspan(int i, Pointer s) {
		return MeosLibrary.meos.contained_int_intspan(i, s);
	}
	
	public static boolean contained_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.contained_period_periodset(p, ps);
	}
	
	public static boolean contained_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.contained_periodset_period(ps, p);
	}
	
	public static boolean contained_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.contained_periodset_periodset(ps1, ps2);
	}
	
	public static boolean contained_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.contained_span_span(s1, s2);
	}
	
	public static boolean contained_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.contained_timestamp_period(t, p);
	}
	
	public static boolean contained_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.contained_timestamp_periodset(t, ps);
	}
	
	public static boolean contained_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.contained_timestamp_timestampset(t, ts);
	}
	
	public static boolean contained_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.contained_timestampset_period(ts, p);
	}
	
	public static boolean contained_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.contained_timestampset_periodset(ts, ps);
	}
	
	public static boolean contained_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.contained_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean contains_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.contains_floatspan_float(s, d);
	}
	
	public static boolean contains_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.contains_intspan_int(s, i);
	}
	
	public static boolean contains_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.contains_period_periodset(p, ps);
	}
	
	public static boolean contains_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.contains_period_timestamp(p, t);
	}
	
	public static boolean contains_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.contains_period_timestampset(p, ts);
	}
	
	public static boolean contains_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.contains_periodset_period(ps, p);
	}
	
	public static boolean contains_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.contains_periodset_periodset(ps1, ps2);
	}
	
	public static boolean contains_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.contains_periodset_timestamp(ps, t);
	}
	
	public static boolean contains_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.contains_periodset_timestampset(ps, ts);
	}
	
	public static boolean contains_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.contains_span_span(s1, s2);
	}
	
	public static boolean contains_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.contains_timestampset_timestamp(ts, t);
	}
	
	public static boolean contains_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.contains_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean overlaps_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.overlaps_period_periodset(p, ps);
	}
	
	public static boolean overlaps_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.overlaps_period_timestampset(p, ts);
	}
	
	public static boolean overlaps_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.overlaps_periodset_period(ps, p);
	}
	
	public static boolean overlaps_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.overlaps_periodset_periodset(ps1, ps2);
	}
	
	public static boolean overlaps_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.overlaps_periodset_timestampset(ps, ts);
	}
	
	public static boolean overlaps_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.overlaps_span_span(s1, s2);
	}
	
	public static boolean overlaps_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.overlaps_timestampset_period(ts, p);
	}
	
	public static boolean overlaps_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.overlaps_timestampset_periodset(ts, ps);
	}
	
	public static boolean overlaps_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.overlaps_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean after_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.after_period_periodset(p, ps);
	}
	
	public static boolean after_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.after_period_timestamp(p, t);
	}
	
	public static boolean after_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.after_period_timestampset(p, ts);
	}
	
	public static boolean after_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.after_periodset_period(ps, p);
	}
	
	public static boolean after_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.after_periodset_periodset(ps1, ps2);
	}
	
	public static boolean after_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.after_periodset_timestamp(ps, t);
	}
	
	public static boolean after_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.after_periodset_timestampset(ps, ts);
	}
	
	public static boolean after_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.after_timestamp_period(t, p);
	}
	
	public static boolean after_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.after_timestamp_periodset(t, ps);
	}
	
	public static boolean after_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.after_timestamp_timestampset(t, ts);
	}
	
	public static boolean after_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.after_timestampset_period(ts, p);
	}
	
	public static boolean after_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.after_timestampset_periodset(ts, ps);
	}
	
	public static boolean after_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.after_timestampset_timestamp(ts, t);
	}
	
	public static boolean after_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.after_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean before_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.before_period_periodset(p, ps);
	}
	
	public static boolean before_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.before_period_timestamp(p, t);
	}
	
	public static boolean before_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.before_period_timestampset(p, ts);
	}
	
	public static boolean before_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.before_periodset_period(ps, p);
	}
	
	public static boolean before_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.before_periodset_periodset(ps1, ps2);
	}
	
	public static boolean before_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.before_periodset_timestamp(ps, t);
	}
	
	public static boolean before_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.before_periodset_timestampset(ps, ts);
	}
	
	public static boolean before_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.before_timestamp_period(t, p);
	}
	
	public static boolean before_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.before_timestamp_periodset(t, ps);
	}
	
	public static boolean before_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.before_timestamp_timestampset(t, ts);
	}
	
	public static boolean before_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.before_timestampset_period(ts, p);
	}
	
	public static boolean before_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.before_timestampset_periodset(ts, ps);
	}
	
	public static boolean before_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.before_timestampset_timestamp(ts, t);
	}
	
	public static boolean before_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.before_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean left_float_floatspan(double d, Pointer s) {
		return MeosLibrary.meos.left_float_floatspan(d, s);
	}
	
	public static boolean left_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.left_floatspan_float(s, d);
	}
	
	public static boolean left_int_intspan(int i, Pointer s) {
		return MeosLibrary.meos.left_int_intspan(i, s);
	}
	
	public static boolean left_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.left_intspan_int(s, i);
	}
	
	public static boolean left_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.left_span_span(s1, s2);
	}
	
	public static boolean overafter_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.overafter_period_periodset(p, ps);
	}
	
	public static boolean overafter_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.overafter_period_timestamp(p, t);
	}
	
	public static boolean overafter_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.overafter_period_timestampset(p, ts);
	}
	
	public static boolean overafter_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.overafter_periodset_period(ps, p);
	}
	
	public static boolean overafter_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.overafter_periodset_periodset(ps1, ps2);
	}
	
	public static boolean overafter_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.overafter_periodset_timestamp(ps, t);
	}
	
	public static boolean overafter_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.overafter_periodset_timestampset(ps, ts);
	}
	
	public static boolean overafter_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.overafter_timestamp_period(t, p);
	}
	
	public static boolean overafter_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.overafter_timestamp_periodset(t, ps);
	}
	
	public static boolean overafter_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.overafter_timestamp_timestampset(t, ts);
	}
	
	public static boolean overafter_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.overafter_timestampset_period(ts, p);
	}
	
	public static boolean overafter_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.overafter_timestampset_periodset(ts, ps);
	}
	
	public static boolean overafter_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.overafter_timestampset_timestamp(ts, t);
	}
	
	public static boolean overafter_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.overafter_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean overbefore_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.overbefore_period_periodset(p, ps);
	}
	
	public static boolean overbefore_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.overbefore_period_timestamp(p, t);
	}
	
	public static boolean overbefore_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.overbefore_period_timestampset(p, ts);
	}
	
	public static boolean overbefore_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.overbefore_periodset_period(ps, p);
	}
	
	public static boolean overbefore_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.overbefore_periodset_periodset(ps1, ps2);
	}
	
	public static boolean overbefore_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.overbefore_periodset_timestamp(ps, t);
	}
	
	public static boolean overbefore_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.overbefore_periodset_timestampset(ps, ts);
	}
	
	public static boolean overbefore_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.overbefore_timestamp_period(t, p);
	}
	
	public static boolean overbefore_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.overbefore_timestamp_periodset(t, ps);
	}
	
	public static boolean overbefore_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.overbefore_timestamp_timestampset(t, ts);
	}
	
	public static boolean overbefore_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.overbefore_timestampset_period(ts, p);
	}
	
	public static boolean overbefore_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.overbefore_timestampset_periodset(ts, ps);
	}
	
	public static boolean overbefore_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.overbefore_timestampset_timestamp(ts, t);
	}
	
	public static boolean overbefore_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.overbefore_timestampset_timestampset(ts1, ts2);
	}
	
	public static boolean overleft_float_floatspan(double d, Pointer s) {
		return MeosLibrary.meos.overleft_float_floatspan(d, s);
	}
	
	public static boolean overleft_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.overleft_floatspan_float(s, d);
	}
	
	public static boolean overleft_int_intspan(int i, Pointer s) {
		return MeosLibrary.meos.overleft_int_intspan(i, s);
	}
	
	public static boolean overleft_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.overleft_intspan_int(s, i);
	}
	
	public static boolean overleft_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.overleft_span_span(s1, s2);
	}
	
	public static boolean overright_float_floatspan(double d, Pointer s) {
		return MeosLibrary.meos.overright_float_floatspan(d, s);
	}
	
	public static boolean overright_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.overright_floatspan_float(s, d);
	}
	
	public static boolean overright_int_intspan(int i, Pointer s) {
		return MeosLibrary.meos.overright_int_intspan(i, s);
	}
	
	public static boolean overright_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.overright_intspan_int(s, i);
	}
	
	public static boolean overright_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.overright_span_span(s1, s2);
	}
	
	public static boolean right_float_floatspan(double d, Pointer s) {
		return MeosLibrary.meos.right_float_floatspan(d, s);
	}
	
	public static boolean right_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.right_floatspan_float(s, d);
	}
	
	public static boolean right_int_intspan(int i, Pointer s) {
		return MeosLibrary.meos.right_int_intspan(i, s);
	}
	
	public static boolean right_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.right_intspan_int(s, i);
	}
	
	public static boolean right_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.right_span_span(s1, s2);
	}
	
	public static Pointer intersection_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.intersection_period_periodset(p, ps);
	}
	
	public static boolean intersection_period_timestamp(Pointer p, int t, Pointer result) {
		return MeosLibrary.meos.intersection_period_timestamp(p, t, result);
	}
	
	public static Pointer intersection_period_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.intersection_period_timestampset(ps, ts);
	}
	
	public static Pointer intersection_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.intersection_periodset_period(ps, p);
	}
	
	public static Pointer intersection_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.intersection_periodset_periodset(ps1, ps2);
	}
	
	public static boolean intersection_periodset_timestamp(Pointer ps, int t, Pointer result) {
		return MeosLibrary.meos.intersection_periodset_timestamp(ps, t, result);
	}
	
	public static Pointer intersection_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.intersection_periodset_timestampset(ps, ts);
	}
	
	public static Pointer intersection_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.intersection_span_span(s1, s2);
	}
	
	public static boolean intersection_timestamp_period(int t, Pointer p, Pointer result) {
		return MeosLibrary.meos.intersection_timestamp_period(t, p, result);
	}
	
	public static boolean intersection_timestamp_periodset(int t, Pointer ps, Pointer result) {
		return MeosLibrary.meos.intersection_timestamp_periodset(t, ps, result);
	}
	
	public static boolean intersection_timestamp_timestamp(int t1, int t2, Pointer result) {
		return MeosLibrary.meos.intersection_timestamp_timestamp(t1, t2, result);
	}
	
	public static boolean intersection_timestamp_timestampset(int t, Pointer ts, Pointer result) {
		return MeosLibrary.meos.intersection_timestamp_timestampset(t, ts, result);
	}
	
	public static Pointer intersection_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.intersection_timestampset_period(ts, p);
	}
	
	public static Pointer intersection_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.intersection_timestampset_periodset(ts, ps);
	}
	
	public static boolean intersection_timestampset_timestamp(Pointer ts, int t, Pointer result) {
		return MeosLibrary.meos.intersection_timestampset_timestamp(ts, t, result);
	}
	
	public static Pointer intersection_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.intersection_timestampset_timestampset(ts1, ts2);
	}
	
	public static Pointer minus_period_period(Pointer p1, Pointer p2) {
		return MeosLibrary.meos.minus_period_period(p1, p2);
	}
	
	public static Pointer minus_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.minus_period_periodset(p, ps);
	}
	
	public static Pointer minus_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.minus_period_timestamp(p, t);
	}
	
	public static Pointer minus_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.minus_period_timestampset(p, ts);
	}
	
	public static Pointer minus_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.minus_periodset_period(ps, p);
	}
	
	public static Pointer minus_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.minus_periodset_periodset(ps1, ps2);
	}
	
	public static Pointer minus_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.minus_periodset_timestamp(ps, t);
	}
	
	public static Pointer minus_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.minus_periodset_timestampset(ps, ts);
	}
	
	public static Pointer minus_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.minus_span_span(s1, s2);
	}
	
	public static boolean minus_timestamp_period(int t, Pointer p, Pointer result) {
		return MeosLibrary.meos.minus_timestamp_period(t, p, result);
	}
	
	public static boolean minus_timestamp_periodset(int t, Pointer ps, Pointer result) {
		return MeosLibrary.meos.minus_timestamp_periodset(t, ps, result);
	}
	
	public static boolean minus_timestamp_timestamp(int t1, int t2, Pointer result) {
		return MeosLibrary.meos.minus_timestamp_timestamp(t1, t2, result);
	}
	
	public static boolean minus_timestamp_timestampset(int t, Pointer ts, Pointer result) {
		return MeosLibrary.meos.minus_timestamp_timestampset(t, ts, result);
	}
	
	public static Pointer minus_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.minus_timestampset_period(ts, p);
	}
	
	public static Pointer minus_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.minus_timestampset_periodset(ts, ps);
	}
	
	public static Pointer minus_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.minus_timestampset_timestamp(ts, t);
	}
	
	public static Pointer minus_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.minus_timestampset_timestampset(ts1, ts2);
	}
	
	public static Pointer union_period_period(Pointer p1, Pointer p2) {
		return MeosLibrary.meos.union_period_period(p1, p2);
	}
	
	public static Pointer union_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.union_period_periodset(p, ps);
	}
	
	public static Pointer union_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.union_period_timestamp(p, t);
	}
	
	public static Pointer union_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.union_period_timestampset(p, ts);
	}
	
	public static Pointer union_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.union_periodset_period(ps, p);
	}
	
	public static Pointer union_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.union_periodset_periodset(ps1, ps2);
	}
	
	public static Pointer union_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.union_periodset_timestamp(ps, t);
	}
	
	public static Pointer union_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.union_periodset_timestampset(ps, ts);
	}
	
	public static Pointer union_span_span(Pointer s1, Pointer s2, boolean strict) {
		return MeosLibrary.meos.union_span_span(s1, s2, strict);
	}
	
	public static Pointer union_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.union_timestamp_period(t, p);
	}
	
	public static Pointer union_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.union_timestamp_periodset(t, ps);
	}
	
	public static Pointer union_timestamp_timestamp(int t1, int t2) {
		return MeosLibrary.meos.union_timestamp_timestamp(t1, t2);
	}
	
	public static Pointer union_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.union_timestamp_timestampset(t, ts);
	}
	
	public static Pointer union_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.union_timestampset_period(ts, p);
	}
	
	public static Pointer union_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.union_timestampset_periodset(ts, ps);
	}
	
	public static Pointer union_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.union_timestampset_timestamp(ts, t);
	}
	
	public static Pointer union_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.union_timestampset_timestampset(ts1, ts2);
	}
	
	public static double distance_floatspan_float(Pointer s, double d) {
		return MeosLibrary.meos.distance_floatspan_float(s, d);
	}
	
	public static double distance_intspan_int(Pointer s, int i) {
		return MeosLibrary.meos.distance_intspan_int(s, i);
	}
	
	public static double distance_period_periodset(Pointer p, Pointer ps) {
		return MeosLibrary.meos.distance_period_periodset(p, ps);
	}
	
	public static double distance_period_timestamp(Pointer p, int t) {
		return MeosLibrary.meos.distance_period_timestamp(p, t);
	}
	
	public static double distance_period_timestampset(Pointer p, Pointer ts) {
		return MeosLibrary.meos.distance_period_timestampset(p, ts);
	}
	
	public static double distance_periodset_period(Pointer ps, Pointer p) {
		return MeosLibrary.meos.distance_periodset_period(ps, p);
	}
	
	public static double distance_periodset_periodset(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.distance_periodset_periodset(ps1, ps2);
	}
	
	public static double distance_periodset_timestamp(Pointer ps, int t) {
		return MeosLibrary.meos.distance_periodset_timestamp(ps, t);
	}
	
	public static double distance_periodset_timestampset(Pointer ps, Pointer ts) {
		return MeosLibrary.meos.distance_periodset_timestampset(ps, ts);
	}
	
	public static double distance_span_span(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.distance_span_span(s1, s2);
	}
	
	public static double distance_timestamp_period(int t, Pointer p) {
		return MeosLibrary.meos.distance_timestamp_period(t, p);
	}
	
	public static double distance_timestamp_periodset(int t, Pointer ps) {
		return MeosLibrary.meos.distance_timestamp_periodset(t, ps);
	}
	
	public static double distance_timestamp_timestamp(int t1, int t2) {
		return MeosLibrary.meos.distance_timestamp_timestamp(t1, t2);
	}
	
	public static double distance_timestamp_timestampset(int t, Pointer ts) {
		return MeosLibrary.meos.distance_timestamp_timestampset(t, ts);
	}
	
	public static double distance_timestampset_period(Pointer ts, Pointer p) {
		return MeosLibrary.meos.distance_timestampset_period(ts, p);
	}
	
	public static double distance_timestampset_periodset(Pointer ts, Pointer ps) {
		return MeosLibrary.meos.distance_timestampset_periodset(ts, ps);
	}
	
	public static double distance_timestampset_timestamp(Pointer ts, int t) {
		return MeosLibrary.meos.distance_timestampset_timestamp(ts, t);
	}
	
	public static double distance_timestampset_timestampset(Pointer ts1, Pointer ts2) {
		return MeosLibrary.meos.distance_timestampset_timestampset(ts1, ts2);
	}
	
	public static Pointer timestamp_extent_transfn(Pointer p, int t) {
		return MeosLibrary.meos.timestamp_extent_transfn(p, t);
	}
	
	public static Pointer timestampset_extent_transfn(Pointer p, Pointer ts) {
		return MeosLibrary.meos.timestampset_extent_transfn(p, ts);
	}
	
	public static Pointer span_extent_transfn(Pointer p1, Pointer p2) {
		return MeosLibrary.meos.span_extent_transfn(p1, p2);
	}
	
	public static Pointer periodset_extent_transfn(Pointer p, Pointer ps) {
		return MeosLibrary.meos.periodset_extent_transfn(p, ps);
	}
	
	public static Pointer timestamp_tunion_transfn(Pointer state, int t) {
		return MeosLibrary.meos.timestamp_tunion_transfn(state, t);
	}
	
	public static Pointer timestampset_tunion_transfn(Pointer state, Pointer ts) {
		return MeosLibrary.meos.timestampset_tunion_transfn(state, ts);
	}
	
	public static Pointer period_tunion_transfn(Pointer state, Pointer p) {
		return MeosLibrary.meos.period_tunion_transfn(state, p);
	}
	
	public static Pointer periodset_tunion_transfn(Pointer state, Pointer ps) {
		return MeosLibrary.meos.periodset_tunion_transfn(state, ps);
	}
	
	public static Pointer timestamp_tunion_finalfn(Pointer state) {
		return MeosLibrary.meos.timestamp_tunion_finalfn(state);
	}
	
	public static Pointer period_tunion_finalfn(Pointer state) {
		return MeosLibrary.meos.period_tunion_finalfn(state);
	}
	
	public static Pointer timestamp_tcount_transfn(Pointer state, int t, Pointer interval, int origin) {
		return MeosLibrary.meos.timestamp_tcount_transfn(state, t, interval, origin);
	}
	
	public static Pointer timestampset_tcount_transfn(Pointer state, Pointer ts, Pointer interval, int origin) {
		return MeosLibrary.meos.timestampset_tcount_transfn(state, ts, interval, origin);
	}
	
	public static Pointer period_tcount_transfn(Pointer state, Pointer p, Pointer interval, int origin) {
		return MeosLibrary.meos.period_tcount_transfn(state, p, interval, origin);
	}
	
	public static Pointer periodset_tcount_transfn(Pointer state, Pointer ps, Pointer interval, int origin) {
		return MeosLibrary.meos.periodset_tcount_transfn(state, ps, interval, origin);
	}
	
	public static boolean periodset_eq(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_eq(ps1, ps2);
	}
	
	public static boolean periodset_ne(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_ne(ps1, ps2);
	}
	
	public static int periodset_cmp(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_cmp(ps1, ps2);
	}
	
	public static boolean periodset_lt(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_lt(ps1, ps2);
	}
	
	public static boolean periodset_le(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_le(ps1, ps2);
	}
	
	public static boolean periodset_ge(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_ge(ps1, ps2);
	}
	
	public static boolean periodset_gt(Pointer ps1, Pointer ps2) {
		return MeosLibrary.meos.periodset_gt(ps1, ps2);
	}
	
	public static boolean span_eq(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_eq(s1, s2);
	}
	
	public static boolean span_ne(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_ne(s1, s2);
	}
	
	public static int span_cmp(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_cmp(s1, s2);
	}
	
	public static boolean span_lt(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_lt(s1, s2);
	}
	
	public static boolean span_le(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_le(s1, s2);
	}
	
	public static boolean span_ge(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_ge(s1, s2);
	}
	
	public static boolean span_gt(Pointer s1, Pointer s2) {
		return MeosLibrary.meos.span_gt(s1, s2);
	}
	
	public static boolean timestampset_eq(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_eq(ss1, ss2);
	}
	
	public static boolean timestampset_ne(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_ne(ss1, ss2);
	}
	
	public static int timestampset_cmp(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_cmp(ss1, ss2);
	}
	
	public static boolean timestampset_lt(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_lt(ss1, ss2);
	}
	
	public static boolean timestampset_le(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_le(ss1, ss2);
	}
	
	public static boolean timestampset_ge(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_ge(ss1, ss2);
	}
	
	public static boolean timestampset_gt(Pointer ss1, Pointer ss2) {
		return MeosLibrary.meos.timestampset_gt(ss1, ss2);
	}
	
	public static Pointer tbox_in(String str) {
		return MeosLibrary.meos.tbox_in(str);
	}
	
	public static String tbox_out(Pointer box, int maxdd) {
		return MeosLibrary.meos.tbox_out(box, maxdd);
	}
	
	public static Pointer tbox_from_wkb(Pointer wkb, int size) {
		return MeosLibrary.meos.tbox_from_wkb(wkb, size);
	}
	
	public static Pointer tbox_from_hexwkb(String hexwkb) {
		return MeosLibrary.meos.tbox_from_hexwkb(hexwkb);
	}
	
	public static Pointer stbox_from_wkb(Pointer wkb, int size) {
		return MeosLibrary.meos.stbox_from_wkb(wkb, size);
	}
	
	public static Pointer stbox_from_hexwkb(String hexwkb) {
		return MeosLibrary.meos.stbox_from_hexwkb(hexwkb);
	}
	
	public static Pointer tbox_as_wkb(Pointer box, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.tbox_as_wkb(box, variant, size_out);
	}
	
	public static String tbox_as_hexwkb(Pointer box, u_int8_t variant, Pointer size) {
		return MeosLibrary.meos.tbox_as_hexwkb(box, variant, size);
	}
	
	public static Pointer stbox_as_wkb(Pointer box, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.stbox_as_wkb(box, variant, size_out);
	}
	
	public static String stbox_as_hexwkb(Pointer box, u_int8_t variant, Pointer size) {
		return MeosLibrary.meos.stbox_as_hexwkb(box, variant, size);
	}
	
	public static Pointer stbox_in(String str) {
		return MeosLibrary.meos.stbox_in(str);
	}
	
	public static String stbox_out(Pointer box, int maxdd) {
		return MeosLibrary.meos.stbox_out(box, maxdd);
	}
	
	public static Pointer tbox_make(Pointer p, Pointer s) {
		return MeosLibrary.meos.tbox_make(p, s);
	}
	
	public static void tbox_set(Pointer p, Pointer s, Pointer box) {
		MeosLibrary.meos.tbox_set(p, s, box);
	}
	
	public static Pointer tbox_copy(Pointer box) {
		return MeosLibrary.meos.tbox_copy(box);
	}
	
	public static Pointer stbox_copy(Pointer box) {
		return MeosLibrary.meos.stbox_copy(box);
	}
	
	public static Pointer int_to_tbox(int i) {
		return MeosLibrary.meos.int_to_tbox(i);
	}
	
	public static Pointer float_to_tbox(double d) {
		return MeosLibrary.meos.float_to_tbox(d);
	}
	
	public static Pointer span_to_tbox(Pointer span) {
		return MeosLibrary.meos.span_to_tbox(span);
	}
	
	public static Pointer timestamp_to_tbox(int t) {
		return MeosLibrary.meos.timestamp_to_tbox(t);
	}
	
	public static Pointer timestampset_to_tbox(Pointer ss) {
		return MeosLibrary.meos.timestampset_to_tbox(ss);
	}
	
	public static Pointer period_to_tbox(Pointer p) {
		return MeosLibrary.meos.period_to_tbox(p);
	}
	
	public static Pointer periodset_to_tbox(Pointer ps) {
		return MeosLibrary.meos.periodset_to_tbox(ps);
	}
	
	public static Pointer int_timestamp_to_tbox(int i, int t) {
		return MeosLibrary.meos.int_timestamp_to_tbox(i, t);
	}
	
	public static Pointer float_timestamp_to_tbox(double d, int t) {
		return MeosLibrary.meos.float_timestamp_to_tbox(d, t);
	}
	
	public static Pointer int_period_to_tbox(int i, Pointer p) {
		return MeosLibrary.meos.int_period_to_tbox(i, p);
	}
	
	public static Pointer float_period_to_tbox(double d, Pointer p) {
		return MeosLibrary.meos.float_period_to_tbox(d, p);
	}
	
	public static Pointer span_timestamp_to_tbox(Pointer span, int t) {
		return MeosLibrary.meos.span_timestamp_to_tbox(span, t);
	}
	
	public static Pointer span_period_to_tbox(Pointer span, Pointer p) {
		return MeosLibrary.meos.span_period_to_tbox(span, p);
	}
	
	public static Pointer tbox_to_floatspan(Pointer box) {
		return MeosLibrary.meos.tbox_to_floatspan(box);
	}
	
	public static Pointer tbox_to_period(Pointer box) {
		return MeosLibrary.meos.tbox_to_period(box);
	}
	
	public static Pointer stbox_to_period(Pointer box) {
		return MeosLibrary.meos.stbox_to_period(box);
	}
	
	public static Pointer tnumber_to_tbox(Pointer temp) {
		return MeosLibrary.meos.tnumber_to_tbox(temp);
	}
	
	public static Pointer stbox_to_geo(Pointer box) {
		return MeosLibrary.meos.stbox_to_geo(box);
	}
	
	public static Pointer tpoint_to_stbox(Pointer temp) {
		return MeosLibrary.meos.tpoint_to_stbox(temp);
	}
	
	public static Pointer geo_to_stbox(Pointer gs) {
		return MeosLibrary.meos.geo_to_stbox(gs);
	}
	
	public static Pointer timestamp_to_stbox(int t) {
		return MeosLibrary.meos.timestamp_to_stbox(t);
	}
	
	public static Pointer timestampset_to_stbox(Pointer ts) {
		return MeosLibrary.meos.timestampset_to_stbox(ts);
	}
	
	public static Pointer period_to_stbox(Pointer p) {
		return MeosLibrary.meos.period_to_stbox(p);
	}
	
	public static Pointer periodset_to_stbox(Pointer ps) {
		return MeosLibrary.meos.periodset_to_stbox(ps);
	}
	
	public static Pointer geo_timestamp_to_stbox(Pointer gs, int t) {
		return MeosLibrary.meos.geo_timestamp_to_stbox(gs, t);
	}
	
	public static Pointer geo_period_to_stbox(Pointer gs, Pointer p) {
		return MeosLibrary.meos.geo_period_to_stbox(gs, p);
	}
	
	public static boolean tbox_hasx(Pointer box) {
		return MeosLibrary.meos.tbox_hasx(box);
	}
	
	public static boolean tbox_hast(Pointer box) {
		return MeosLibrary.meos.tbox_hast(box);
	}
	
	public static boolean tbox_xmin(Pointer box, Pointer result) {
		return MeosLibrary.meos.tbox_xmin(box, result);
	}
	
	public static boolean tbox_xmax(Pointer box, Pointer result) {
		return MeosLibrary.meos.tbox_xmax(box, result);
	}
	
	public static boolean tbox_tmin(Pointer box, Pointer result) {
		return MeosLibrary.meos.tbox_tmin(box, result);
	}
	
	public static boolean tbox_tmax(Pointer box, Pointer result) {
		return MeosLibrary.meos.tbox_tmax(box, result);
	}
	
	public static boolean stbox_hasx(Pointer box) {
		return MeosLibrary.meos.stbox_hasx(box);
	}
	
	public static boolean stbox_hasz(Pointer box) {
		return MeosLibrary.meos.stbox_hasz(box);
	}
	
	public static boolean stbox_hast(Pointer box) {
		return MeosLibrary.meos.stbox_hast(box);
	}
	
	public static boolean stbox_isgeodetic(Pointer box) {
		return MeosLibrary.meos.stbox_isgeodetic(box);
	}
	
	public static boolean stbox_xmin(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_xmin(box, result);
	}
	
	public static boolean stbox_xmax(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_xmax(box, result);
	}
	
	public static boolean stbox_ymin(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_ymin(box, result);
	}
	
	public static boolean stbox_ymax(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_ymax(box, result);
	}
	
	public static boolean stbox_zmin(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_zmin(box, result);
	}
	
	public static boolean stbox_zmax(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_zmax(box, result);
	}
	
	public static boolean stbox_tmin(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_tmin(box, result);
	}
	
	public static boolean stbox_tmax(Pointer box, Pointer result) {
		return MeosLibrary.meos.stbox_tmax(box, result);
	}
	
	public static int32_t stbox_srid(Pointer box) {
		return MeosLibrary.meos.stbox_srid(box);
	}
	
	public static void tbox_expand(Pointer box1, Pointer box2) {
		MeosLibrary.meos.tbox_expand(box1, box2);
	}
	
	public static void tbox_shift_tscale(Pointer start, Pointer duration, Pointer box) {
		MeosLibrary.meos.tbox_shift_tscale(start, duration, box);
	}
	
	public static Pointer tbox_expand_value(Pointer box, double d) {
		return MeosLibrary.meos.tbox_expand_value(box, d);
	}
	
	public static Pointer tbox_expand_temporal(Pointer box, Pointer interval) {
		return MeosLibrary.meos.tbox_expand_temporal(box, interval);
	}
	
	public static void stbox_expand(Pointer box1, Pointer box2) {
		MeosLibrary.meos.stbox_expand(box1, box2);
	}
	
	public static void stbox_shift_tscale(Pointer start, Pointer duration, Pointer box) {
		MeosLibrary.meos.stbox_shift_tscale(start, duration, box);
	}
	
	public static Pointer stbox_set_srid(Pointer box, int32_t srid) {
		return MeosLibrary.meos.stbox_set_srid(box, srid);
	}
	
	public static Pointer stbox_expand_spatial(Pointer box, double d) {
		return MeosLibrary.meos.stbox_expand_spatial(box, d);
	}
	
	public static Pointer stbox_expand_temporal(Pointer box, Pointer interval) {
		return MeosLibrary.meos.stbox_expand_temporal(box, interval);
	}
	
	public static boolean contains_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.contains_tbox_tbox(box1, box2);
	}
	
	public static boolean contained_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.contained_tbox_tbox(box1, box2);
	}
	
	public static boolean overlaps_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overlaps_tbox_tbox(box1, box2);
	}
	
	public static boolean same_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.same_tbox_tbox(box1, box2);
	}
	
	public static boolean adjacent_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.adjacent_tbox_tbox(box1, box2);
	}
	
	public static boolean contains_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.contains_stbox_stbox(box1, box2);
	}
	
	public static boolean contained_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.contained_stbox_stbox(box1, box2);
	}
	
	public static boolean overlaps_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overlaps_stbox_stbox(box1, box2);
	}
	
	public static boolean same_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.same_stbox_stbox(box1, box2);
	}
	
	public static boolean adjacent_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.adjacent_stbox_stbox(box1, box2);
	}
	
	public static boolean left_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.left_tbox_tbox(box1, box2);
	}
	
	public static boolean overleft_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overleft_tbox_tbox(box1, box2);
	}
	
	public static boolean right_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.right_tbox_tbox(box1, box2);
	}
	
	public static boolean overright_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overright_tbox_tbox(box1, box2);
	}
	
	public static boolean before_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.before_tbox_tbox(box1, box2);
	}
	
	public static boolean overbefore_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overbefore_tbox_tbox(box1, box2);
	}
	
	public static boolean after_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.after_tbox_tbox(box1, box2);
	}
	
	public static boolean overafter_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overafter_tbox_tbox(box1, box2);
	}
	
	public static boolean left_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.left_stbox_stbox(box1, box2);
	}
	
	public static boolean overleft_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overleft_stbox_stbox(box1, box2);
	}
	
	public static boolean right_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.right_stbox_stbox(box1, box2);
	}
	
	public static boolean overright_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overright_stbox_stbox(box1, box2);
	}
	
	public static boolean below_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.below_stbox_stbox(box1, box2);
	}
	
	public static boolean overbelow_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overbelow_stbox_stbox(box1, box2);
	}
	
	public static boolean above_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.above_stbox_stbox(box1, box2);
	}
	
	public static boolean overabove_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overabove_stbox_stbox(box1, box2);
	}
	
	public static boolean front_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.front_stbox_stbox(box1, box2);
	}
	
	public static boolean overfront_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overfront_stbox_stbox(box1, box2);
	}
	
	public static boolean back_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.back_stbox_stbox(box1, box2);
	}
	
	public static boolean overback_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overback_stbox_stbox(box1, box2);
	}
	
	public static boolean before_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.before_stbox_stbox(box1, box2);
	}
	
	public static boolean overbefore_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overbefore_stbox_stbox(box1, box2);
	}
	
	public static boolean after_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.after_stbox_stbox(box1, box2);
	}
	
	public static boolean overafter_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.overafter_stbox_stbox(box1, box2);
	}
	
	public static Pointer union_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.union_tbox_tbox(box1, box2);
	}
	
	public static boolean inter_tbox_tbox(Pointer box1, Pointer box2, Pointer result) {
		return MeosLibrary.meos.inter_tbox_tbox(box1, box2, result);
	}
	
	public static Pointer intersection_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.intersection_tbox_tbox(box1, box2);
	}
	
	public static Pointer union_stbox_stbox(Pointer box1, Pointer box2, boolean strict) {
		return MeosLibrary.meos.union_stbox_stbox(box1, box2, strict);
	}
	
	public static boolean inter_stbox_stbox(Pointer box1, Pointer box2, Pointer result) {
		return MeosLibrary.meos.inter_stbox_stbox(box1, box2, result);
	}
	
	public static Pointer intersection_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.intersection_stbox_stbox(box1, box2);
	}
	
	public static boolean tbox_eq(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_eq(box1, box2);
	}
	
	public static boolean tbox_ne(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_ne(box1, box2);
	}
	
	public static int tbox_cmp(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_cmp(box1, box2);
	}
	
	public static boolean tbox_lt(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_lt(box1, box2);
	}
	
	public static boolean tbox_le(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_le(box1, box2);
	}
	
	public static boolean tbox_ge(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_ge(box1, box2);
	}
	
	public static boolean tbox_gt(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.tbox_gt(box1, box2);
	}
	
	public static boolean stbox_eq(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_eq(box1, box2);
	}
	
	public static boolean stbox_ne(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_ne(box1, box2);
	}
	
	public static int stbox_cmp(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_cmp(box1, box2);
	}
	
	public static boolean stbox_lt(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_lt(box1, box2);
	}
	
	public static boolean stbox_le(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_le(box1, box2);
	}
	
	public static boolean stbox_ge(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_ge(box1, box2);
	}
	
	public static boolean stbox_gt(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.stbox_gt(box1, box2);
	}
	
	public static Pointer cstring2text(String cstring) {
		return MeosLibrary.meos.cstring2text(cstring);
	}
	
	public static String text2cstring(Pointer textptr) {
		return MeosLibrary.meos.text2cstring(textptr);
	}
	
	public static Pointer tbool_in(String str) {
		return MeosLibrary.meos.tbool_in(str);
	}
	
	public static String tbool_out(Pointer temp) {
		return MeosLibrary.meos.tbool_out(temp);
	}
	
	public static String temporal_as_hexwkb(Pointer temp, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.temporal_as_hexwkb(temp, variant, size_out);
	}
	
	public static String temporal_as_mfjson(Pointer temp, boolean with_bbox, int flags, int precision, String srs) {
		return MeosLibrary.meos.temporal_as_mfjson(temp, with_bbox, flags, precision, srs);
	}
	
	public static Pointer temporal_as_wkb(Pointer temp, u_int8_t variant, Pointer size_out) {
		return MeosLibrary.meos.temporal_as_wkb(temp, variant, size_out);
	}
	
	public static Pointer temporal_from_hexwkb(String hexwkb) {
		return MeosLibrary.meos.temporal_from_hexwkb(hexwkb);
	}
	
	public static Pointer temporal_from_mfjson(String mfjson) {
		return MeosLibrary.meos.temporal_from_mfjson(mfjson);
	}
	
	public static Pointer temporal_from_wkb(Pointer wkb, int size) {
		return MeosLibrary.meos.temporal_from_wkb(wkb, size);
	}
	
	public static Pointer tfloat_in(String str) {
		return MeosLibrary.meos.tfloat_in(str);
	}
	
	public static String tfloat_out(Pointer temp, int maxdd) {
		return MeosLibrary.meos.tfloat_out(temp, maxdd);
	}
	
	public static Pointer tgeogpoint_in(String str) {
		return MeosLibrary.meos.tgeogpoint_in(str);
	}
	
	public static Pointer tgeompoint_in(String str) {
		return MeosLibrary.meos.tgeompoint_in(str);
	}
	
	public static Pointer tint_in(String str) {
		return MeosLibrary.meos.tint_in(str);
	}
	
	public static String tint_out(Pointer temp) {
		return MeosLibrary.meos.tint_out(temp);
	}
	
	public static String tpoint_as_ewkt(Pointer temp, int maxdd) {
		return MeosLibrary.meos.tpoint_as_ewkt(temp, maxdd);
	}
	
	public static String tpoint_as_text(Pointer temp, int maxdd) {
		return MeosLibrary.meos.tpoint_as_text(temp, maxdd);
	}
	
	public static String tpoint_out(Pointer temp, int maxdd) {
		return MeosLibrary.meos.tpoint_out(temp, maxdd);
	}
	
	public static Pointer ttext_in(String str) {
		return MeosLibrary.meos.ttext_in(str);
	}
	
	public static String ttext_out(Pointer temp) {
		return MeosLibrary.meos.ttext_out(temp);
	}
	
	public static Pointer tbool_from_base(boolean b, Pointer temp) {
		return MeosLibrary.meos.tbool_from_base(b, temp);
	}
	
	public static Pointer tboolinst_make(boolean b, int t) {
		return MeosLibrary.meos.tboolinst_make(b, t);
	}
	
	public static Pointer tbooldiscseq_from_base_time(boolean b, Pointer ts) {
		return MeosLibrary.meos.tbooldiscseq_from_base_time(b, ts);
	}
	
	public static Pointer tboolseq_from_base(boolean b, Pointer seq) {
		return MeosLibrary.meos.tboolseq_from_base(b, seq);
	}
	
	public static Pointer tboolseq_from_base_time(boolean b, Pointer p) {
		return MeosLibrary.meos.tboolseq_from_base_time(b, p);
	}
	
	public static Pointer tboolseqset_from_base(boolean b, Pointer ss) {
		return MeosLibrary.meos.tboolseqset_from_base(b, ss);
	}
	
	public static Pointer tboolseqset_from_base_time(boolean b, Pointer ps) {
		return MeosLibrary.meos.tboolseqset_from_base_time(b, ps);
	}
	
	public static Pointer temporal_copy(Pointer temp) {
		return MeosLibrary.meos.temporal_copy(temp);
	}
	
	public static Pointer tfloat_from_base(double d, Pointer temp, interpType interp) {
		return MeosLibrary.meos.tfloat_from_base(d, temp, interp);
	}
	
	public static Pointer tfloatinst_make(double d, int t) {
		return MeosLibrary.meos.tfloatinst_make(d, t);
	}
	
	public static Pointer tfloatdiscseq_from_base_time(double d, Pointer ts) {
		return MeosLibrary.meos.tfloatdiscseq_from_base_time(d, ts);
	}
	
	public static Pointer tfloatseq_from_base(double d, Pointer seq, interpType interp) {
		return MeosLibrary.meos.tfloatseq_from_base(d, seq, interp);
	}
	
	public static Pointer tfloatseq_from_base_time(double d, Pointer p, interpType interp) {
		return MeosLibrary.meos.tfloatseq_from_base_time(d, p, interp);
	}
	
	public static Pointer tfloatseqset_from_base(double d, Pointer ss, interpType interp) {
		return MeosLibrary.meos.tfloatseqset_from_base(d, ss, interp);
	}
	
	public static Pointer tfloatseqset_from_base_time(double d, Pointer ps, interpType interp) {
		return MeosLibrary.meos.tfloatseqset_from_base_time(d, ps, interp);
	}
	
	public static Pointer tgeogpoint_from_base(Pointer gs, Pointer temp, interpType interp) {
		return MeosLibrary.meos.tgeogpoint_from_base(gs, temp, interp);
	}
	
	public static Pointer tgeogpointinst_make(Pointer gs, int t) {
		return MeosLibrary.meos.tgeogpointinst_make(gs, t);
	}
	
	public static Pointer tgeogpointdiscseq_from_base_time(Pointer gs, Pointer ts) {
		return MeosLibrary.meos.tgeogpointdiscseq_from_base_time(gs, ts);
	}
	
	public static Pointer tgeogpointseq_from_base(Pointer gs, Pointer seq, interpType interp) {
		return MeosLibrary.meos.tgeogpointseq_from_base(gs, seq, interp);
	}
	
	public static Pointer tgeogpointseq_from_base_time(Pointer gs, Pointer p, interpType interp) {
		return MeosLibrary.meos.tgeogpointseq_from_base_time(gs, p, interp);
	}
	
	public static Pointer tgeogpointseqset_from_base(Pointer gs, Pointer ss, interpType interp) {
		return MeosLibrary.meos.tgeogpointseqset_from_base(gs, ss, interp);
	}
	
	public static Pointer tgeogpointseqset_from_base_time(Pointer gs, Pointer ps, interpType interp) {
		return MeosLibrary.meos.tgeogpointseqset_from_base_time(gs, ps, interp);
	}
	
	public static Pointer tgeompoint_from_base(Pointer gs, Pointer temp, interpType interp) {
		return MeosLibrary.meos.tgeompoint_from_base(gs, temp, interp);
	}
	
	public static Pointer tgeompointinst_make(Pointer gs, int t) {
		return MeosLibrary.meos.tgeompointinst_make(gs, t);
	}
	
	public static Pointer tgeompointdiscseq_from_base_time(Pointer gs, Pointer ts) {
		return MeosLibrary.meos.tgeompointdiscseq_from_base_time(gs, ts);
	}
	
	public static Pointer tgeompointseq_from_base(Pointer gs, Pointer seq, interpType interp) {
		return MeosLibrary.meos.tgeompointseq_from_base(gs, seq, interp);
	}
	
	public static Pointer tgeompointseq_from_base_time(Pointer gs, Pointer p, interpType interp) {
		return MeosLibrary.meos.tgeompointseq_from_base_time(gs, p, interp);
	}
	
	public static Pointer tgeompointseqset_from_base(Pointer gs, Pointer ss, interpType interp) {
		return MeosLibrary.meos.tgeompointseqset_from_base(gs, ss, interp);
	}
	
	public static Pointer tgeompointseqset_from_base_time(Pointer gs, Pointer ps, interpType interp) {
		return MeosLibrary.meos.tgeompointseqset_from_base_time(gs, ps, interp);
	}
	
	public static Pointer tint_from_base(int i, Pointer temp) {
		return MeosLibrary.meos.tint_from_base(i, temp);
	}
	
	public static Pointer tintinst_make(int i, int t) {
		return MeosLibrary.meos.tintinst_make(i, t);
	}
	
	public static Pointer tintdiscseq_from_base_time(int i, Pointer ts) {
		return MeosLibrary.meos.tintdiscseq_from_base_time(i, ts);
	}
	
	public static Pointer tintseq_from_base(int i, Pointer seq) {
		return MeosLibrary.meos.tintseq_from_base(i, seq);
	}
	
	public static Pointer tintseq_from_base_time(int i, Pointer p) {
		return MeosLibrary.meos.tintseq_from_base_time(i, p);
	}
	
	public static Pointer tintseqset_from_base(int i, Pointer ss) {
		return MeosLibrary.meos.tintseqset_from_base(i, ss);
	}
	
	public static Pointer tintseqset_from_base_time(int i, Pointer ps) {
		return MeosLibrary.meos.tintseqset_from_base_time(i, ps);
	}
	
	public static Pointer tsequence_make(Pointer[] instants, int count, boolean lower_inc, boolean upper_inc, interpType interp, boolean normalize) {
		return MeosLibrary.meos.tsequence_make(instants, count, lower_inc, upper_inc, interp, normalize);
	}
	
	public static Pointer tsequence_make_exp(Pointer[] instants, int count, int maxcount, boolean lower_inc, boolean upper_inc, interpType interp, boolean normalize) {
		return MeosLibrary.meos.tsequence_make_exp(instants, count, maxcount, lower_inc, upper_inc, interp, normalize);
	}
	
	public static Pointer tsequence_make_free(Pointer[] instants, int count, boolean lower_inc, boolean upper_inc, interpType interp, boolean normalize) {
		return MeosLibrary.meos.tsequence_make_free(instants, count, lower_inc, upper_inc, interp, normalize);
	}
	
	public static Pointer tsequenceset_make(Pointer[] sequences, int count, boolean normalize) {
		return MeosLibrary.meos.tsequenceset_make(sequences, count, normalize);
	}
	
	public static Pointer tsequenceset_make_free(Pointer[] sequences, int count, boolean normalize) {
		return MeosLibrary.meos.tsequenceset_make_free(sequences, count, normalize);
	}
	
	public static Pointer tsequenceset_make_gaps(Pointer[] instants, int count, interpType interp, float maxdist, Pointer maxt) {
		return MeosLibrary.meos.tsequenceset_make_gaps(instants, count, interp, maxdist, maxt);
	}
	
	public static Pointer ttext_from_base(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.ttext_from_base(txt, temp);
	}
	
	public static Pointer ttextinst_make(Pointer txt, int t) {
		return MeosLibrary.meos.ttextinst_make(txt, t);
	}
	
	public static Pointer ttextdiscseq_from_base_time(Pointer txt, Pointer ts) {
		return MeosLibrary.meos.ttextdiscseq_from_base_time(txt, ts);
	}
	
	public static Pointer ttextseq_from_base(Pointer txt, Pointer seq) {
		return MeosLibrary.meos.ttextseq_from_base(txt, seq);
	}
	
	public static Pointer ttextseq_from_base_time(Pointer txt, Pointer p) {
		return MeosLibrary.meos.ttextseq_from_base_time(txt, p);
	}
	
	public static Pointer ttextseqset_from_base(Pointer txt, Pointer ss) {
		return MeosLibrary.meos.ttextseqset_from_base(txt, ss);
	}
	
	public static Pointer ttextseqset_from_base_time(Pointer txt, Pointer ps) {
		return MeosLibrary.meos.ttextseqset_from_base_time(txt, ps);
	}
	
	public static Pointer tfloat_to_tint(Pointer temp) {
		return MeosLibrary.meos.tfloat_to_tint(temp);
	}
	
	public static Pointer tint_to_tfloat(Pointer temp) {
		return MeosLibrary.meos.tint_to_tfloat(temp);
	}
	
	public static Pointer tnumber_to_span(Pointer temp) {
		return MeosLibrary.meos.tnumber_to_span(temp);
	}
	
	public static Pointer temporal_to_period(Pointer temp) {
		return MeosLibrary.meos.temporal_to_period(temp);
	}
	
	public static boolean tbool_end_value(Pointer temp) {
		return MeosLibrary.meos.tbool_end_value(temp);
	}
	
	public static boolean tbool_start_value(Pointer temp) {
		return MeosLibrary.meos.tbool_start_value(temp);
	}
	
	public static Pointer tbool_values(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tbool_values(temp, count);
	}
	
	public static Pointer temporal_duration(Pointer temp) {
		return MeosLibrary.meos.temporal_duration(temp);
	}
	
	public static Pointer temporal_end_sequence(Pointer temp) {
		return MeosLibrary.meos.temporal_end_sequence(temp);
	}
	
	public static int temporal_end_timestamp(Pointer temp) {
		return MeosLibrary.meos.temporal_end_timestamp(temp);
	}
	
	public static u_int32_t temporal_hash(Pointer temp) {
		return MeosLibrary.meos.temporal_hash(temp);
	}
	
	public static String temporal_interpolation(Pointer temp) {
		return MeosLibrary.meos.temporal_interpolation(temp);
	}
	
	public static int temporal_num_instants(Pointer temp) {
		return MeosLibrary.meos.temporal_num_instants(temp);
	}
	
	public static int temporal_num_sequences(Pointer temp) {
		return MeosLibrary.meos.temporal_num_sequences(temp);
	}
	
	public static int temporal_num_timestamps(Pointer temp) {
		return MeosLibrary.meos.temporal_num_timestamps(temp);
	}
	
	public static Pointer[] temporal_segments(Pointer temp, Pointer count) {
		return MeosLibrary.meos.temporal_segments(temp, count);
	}
	
	public static Pointer temporal_sequence_n(Pointer temp, int i) {
		return MeosLibrary.meos.temporal_sequence_n(temp, i);
	}
	
	public static Pointer[] temporal_sequences(Pointer temp, Pointer count) {
		return MeosLibrary.meos.temporal_sequences(temp, count);
	}
	
	public static size_t temporal_size(Pointer temp) {
		return MeosLibrary.meos.temporal_size(temp);
	}
	
	public static Pointer temporal_start_sequence(Pointer temp) {
		return MeosLibrary.meos.temporal_start_sequence(temp);
	}
	
	public static int temporal_start_timestamp(Pointer temp) {
		return MeosLibrary.meos.temporal_start_timestamp(temp);
	}
	
	public static String temporal_subtype(Pointer temp) {
		return MeosLibrary.meos.temporal_subtype(temp);
	}
	
	public static Pointer temporal_time(Pointer temp) {
		return MeosLibrary.meos.temporal_time(temp);
	}
	
	public static Pointer temporal_timespan(Pointer temp) {
		return MeosLibrary.meos.temporal_timespan(temp);
	}
	
	public static boolean temporal_timestamp_n(Pointer temp, int n, Pointer result) {
		return MeosLibrary.meos.temporal_timestamp_n(temp, n, result);
	}
	
	public static Pointer temporal_timestamps(Pointer temp, Pointer count) {
		return MeosLibrary.meos.temporal_timestamps(temp, count);
	}
	
	public static double tfloat_end_value(Pointer temp) {
		return MeosLibrary.meos.tfloat_end_value(temp);
	}
	
	public static double tfloat_max_value(Pointer temp) {
		return MeosLibrary.meos.tfloat_max_value(temp);
	}
	
	public static double tfloat_min_value(Pointer temp) {
		return MeosLibrary.meos.tfloat_min_value(temp);
	}
	
	public static Pointer[] tfloat_spans(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tfloat_spans(temp, count);
	}
	
	public static double tfloat_start_value(Pointer temp) {
		return MeosLibrary.meos.tfloat_start_value(temp);
	}
	
	public static Pointer tfloat_values(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tfloat_values(temp, count);
	}
	
	public static int tint_end_value(Pointer temp) {
		return MeosLibrary.meos.tint_end_value(temp);
	}
	
	public static int tint_max_value(Pointer temp) {
		return MeosLibrary.meos.tint_max_value(temp);
	}
	
	public static int tint_min_value(Pointer temp) {
		return MeosLibrary.meos.tint_min_value(temp);
	}
	
	public static int tint_start_value(Pointer temp) {
		return MeosLibrary.meos.tint_start_value(temp);
	}
	
	public static Pointer tint_values(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tint_values(temp, count);
	}
	
	public static Pointer tpoint_end_value(Pointer temp) {
		return MeosLibrary.meos.tpoint_end_value(temp);
	}
	
	public static Pointer tpoint_start_value(Pointer temp) {
		return MeosLibrary.meos.tpoint_start_value(temp);
	}
	
	public static Pointer[] tpoint_values(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tpoint_values(temp, count);
	}
	
	public static Pointer ttext_end_value(Pointer temp) {
		return MeosLibrary.meos.ttext_end_value(temp);
	}
	
	public static Pointer ttext_max_value(Pointer temp) {
		return MeosLibrary.meos.ttext_max_value(temp);
	}
	
	public static Pointer ttext_min_value(Pointer temp) {
		return MeosLibrary.meos.ttext_min_value(temp);
	}
	
	public static Pointer ttext_start_value(Pointer temp) {
		return MeosLibrary.meos.ttext_start_value(temp);
	}
	
	public static Pointer[] ttext_values(Pointer temp, Pointer count) {
		return MeosLibrary.meos.ttext_values(temp, count);
	}
	
	public static Pointer tsequence_compact(Pointer seq) {
		return MeosLibrary.meos.tsequence_compact(seq);
	}
	
	public static Pointer temporal_append_tinstant(Pointer temp, Pointer inst, boolean expand) {
		return MeosLibrary.meos.temporal_append_tinstant(temp, inst, expand);
	}
	
	public static Pointer temporal_merge(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_merge(temp1, temp2);
	}
	
	public static Pointer temporal_merge_array(Pointer[] temparr, int count) {
		return MeosLibrary.meos.temporal_merge_array(temparr, count);
	}
	
	public static Pointer temporal_shift(Pointer temp, Pointer shift) {
		return MeosLibrary.meos.temporal_shift(temp, shift);
	}
	
	public static Pointer temporal_shift_tscale(Pointer temp, Pointer shift, Pointer duration) {
		return MeosLibrary.meos.temporal_shift_tscale(temp, shift, duration);
	}
	
	public static Pointer temporal_step_to_linear(Pointer temp) {
		return MeosLibrary.meos.temporal_step_to_linear(temp);
	}
	
	public static Pointer temporal_to_tinstant(Pointer temp) {
		return MeosLibrary.meos.temporal_to_tinstant(temp);
	}
	
	public static Pointer temporal_to_tdiscseq(Pointer temp) {
		return MeosLibrary.meos.temporal_to_tdiscseq(temp);
	}
	
	public static Pointer temporal_to_tsequence(Pointer temp) {
		return MeosLibrary.meos.temporal_to_tsequence(temp);
	}
	
	public static Pointer temporal_to_tsequenceset(Pointer temp) {
		return MeosLibrary.meos.temporal_to_tsequenceset(temp);
	}
	
	public static Pointer temporal_tscale(Pointer temp, Pointer duration) {
		return MeosLibrary.meos.temporal_tscale(temp, duration);
	}
	
	public static Pointer tbool_at_value(Pointer temp, boolean b) {
		return MeosLibrary.meos.tbool_at_value(temp, b);
	}
	
	public static Pointer tbool_minus_value(Pointer temp, boolean b) {
		return MeosLibrary.meos.tbool_minus_value(temp, b);
	}
	
	public static boolean tbool_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer value) {
		return MeosLibrary.meos.tbool_value_at_timestamp(temp, t, strict, value);
	}
	
	public static Pointer temporal_at_max(Pointer temp) {
		return MeosLibrary.meos.temporal_at_max(temp);
	}
	
	public static Pointer temporal_at_min(Pointer temp) {
		return MeosLibrary.meos.temporal_at_min(temp);
	}
	
	public static Pointer temporal_at_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.temporal_at_period(temp, p);
	}
	
	public static Pointer temporal_at_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.temporal_at_periodset(temp, ps);
	}
	
	public static Pointer temporal_at_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.temporal_at_timestamp(temp, t);
	}
	
	public static Pointer temporal_at_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.temporal_at_timestampset(temp, ts);
	}
	
	public static Pointer temporal_minus_max(Pointer temp) {
		return MeosLibrary.meos.temporal_minus_max(temp);
	}
	
	public static Pointer temporal_minus_min(Pointer temp) {
		return MeosLibrary.meos.temporal_minus_min(temp);
	}
	
	public static Pointer temporal_minus_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.temporal_minus_period(temp, p);
	}
	
	public static Pointer temporal_minus_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.temporal_minus_periodset(temp, ps);
	}
	
	public static Pointer temporal_minus_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.temporal_minus_timestamp(temp, t);
	}
	
	public static Pointer temporal_minus_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.temporal_minus_timestampset(temp, ts);
	}
	
	public static Pointer tfloat_at_value(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_at_value(temp, d);
	}
	
	public static Pointer tfloat_at_values(Pointer temp, Pointer values, int count) {
		return MeosLibrary.meos.tfloat_at_values(temp, values, count);
	}
	
	public static Pointer tfloat_minus_value(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_minus_value(temp, d);
	}
	
	public static Pointer tfloat_minus_values(Pointer temp, Pointer values, int count) {
		return MeosLibrary.meos.tfloat_minus_values(temp, values, count);
	}
	
	public static boolean tfloat_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer value) {
		return MeosLibrary.meos.tfloat_value_at_timestamp(temp, t, strict, value);
	}
	
	public static Pointer tint_at_value(Pointer temp, int i) {
		return MeosLibrary.meos.tint_at_value(temp, i);
	}
	
	public static Pointer tint_at_values(Pointer temp, Pointer values, int count) {
		return MeosLibrary.meos.tint_at_values(temp, values, count);
	}
	
	public static Pointer tint_minus_value(Pointer temp, int i) {
		return MeosLibrary.meos.tint_minus_value(temp, i);
	}
	
	public static Pointer tint_minus_values(Pointer temp, Pointer values, int count) {
		return MeosLibrary.meos.tint_minus_values(temp, values, count);
	}
	
	public static boolean tint_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer value) {
		return MeosLibrary.meos.tint_value_at_timestamp(temp, t, strict, value);
	}
	
	public static Pointer tnumber_at_span(Pointer temp, Pointer span) {
		return MeosLibrary.meos.tnumber_at_span(temp, span);
	}
	
	public static Pointer tnumber_at_spans(Pointer temp, Pointer[] spans, int count) {
		return MeosLibrary.meos.tnumber_at_spans(temp, spans, count);
	}
	
	public static Pointer tnumber_at_tbox(Pointer temp, Pointer box) {
		return MeosLibrary.meos.tnumber_at_tbox(temp, box);
	}
	
	public static Pointer tnumber_minus_span(Pointer temp, Pointer span) {
		return MeosLibrary.meos.tnumber_minus_span(temp, span);
	}
	
	public static Pointer tnumber_minus_spans(Pointer temp, Pointer[] spans, int count) {
		return MeosLibrary.meos.tnumber_minus_spans(temp, spans, count);
	}
	
	public static Pointer tnumber_minus_tbox(Pointer temp, Pointer box) {
		return MeosLibrary.meos.tnumber_minus_tbox(temp, box);
	}
	
	public static Pointer tpoint_at_geometry(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tpoint_at_geometry(temp, gs);
	}
	
	public static Pointer tpoint_at_stbox(Pointer temp, Pointer box) {
		return MeosLibrary.meos.tpoint_at_stbox(temp, box);
	}
	
	public static Pointer tpoint_at_value(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tpoint_at_value(temp, gs);
	}
	
	public static Pointer tpoint_at_values(Pointer temp, Pointer[] values, int count) {
		return MeosLibrary.meos.tpoint_at_values(temp, values, count);
	}
	
	public static Pointer tpoint_minus_geometry(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tpoint_minus_geometry(temp, gs);
	}
	
	public static Pointer tpoint_minus_stbox(Pointer temp, Pointer box) {
		return MeosLibrary.meos.tpoint_minus_stbox(temp, box);
	}
	
	public static Pointer tpoint_minus_value(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tpoint_minus_value(temp, gs);
	}
	
	public static Pointer tpoint_minus_values(Pointer temp, Pointer[] values, int count) {
		return MeosLibrary.meos.tpoint_minus_values(temp, values, count);
	}
	
	public static boolean tpoint_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer[] value) {
		return MeosLibrary.meos.tpoint_value_at_timestamp(temp, t, strict, value);
	}
	
	public static Pointer ttext_at_value(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_at_value(temp, txt);
	}
	
	public static Pointer ttext_at_values(Pointer temp, Pointer[] values, int count) {
		return MeosLibrary.meos.ttext_at_values(temp, values, count);
	}
	
	public static Pointer ttext_minus_value(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_minus_value(temp, txt);
	}
	
	public static Pointer ttext_minus_values(Pointer temp, Pointer[] values, int count) {
		return MeosLibrary.meos.ttext_minus_values(temp, values, count);
	}
	
	public static boolean ttext_value_at_timestamp(Pointer temp, int t, boolean strict, Pointer[] value) {
		return MeosLibrary.meos.ttext_value_at_timestamp(temp, t, strict, value);
	}
	
	public static Pointer tand_bool_tbool(boolean b, Pointer temp) {
		return MeosLibrary.meos.tand_bool_tbool(b, temp);
	}
	
	public static Pointer tand_tbool_bool(Pointer temp, boolean b) {
		return MeosLibrary.meos.tand_tbool_bool(temp, b);
	}
	
	public static Pointer tand_tbool_tbool(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tand_tbool_tbool(temp1, temp2);
	}
	
	public static Pointer tnot_tbool(Pointer temp) {
		return MeosLibrary.meos.tnot_tbool(temp);
	}
	
	public static Pointer tor_bool_tbool(boolean b, Pointer temp) {
		return MeosLibrary.meos.tor_bool_tbool(b, temp);
	}
	
	public static Pointer tor_tbool_bool(Pointer temp, boolean b) {
		return MeosLibrary.meos.tor_tbool_bool(temp, b);
	}
	
	public static Pointer tor_tbool_tbool(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tor_tbool_tbool(temp1, temp2);
	}
	
	public static Pointer tbool_when_true(Pointer temp) {
		return MeosLibrary.meos.tbool_when_true(temp);
	}
	
	public static Pointer add_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.add_float_tfloat(d, tnumber);
	}
	
	public static Pointer add_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.add_int_tint(i, tnumber);
	}
	
	public static Pointer add_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.add_tfloat_float(tnumber, d);
	}
	
	public static Pointer add_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.add_tint_int(tnumber, i);
	}
	
	public static Pointer add_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.add_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static Pointer div_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.div_float_tfloat(d, tnumber);
	}
	
	public static Pointer div_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.div_int_tint(i, tnumber);
	}
	
	public static Pointer div_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.div_tfloat_float(tnumber, d);
	}
	
	public static Pointer div_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.div_tint_int(tnumber, i);
	}
	
	public static Pointer div_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.div_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static Pointer mult_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.mult_float_tfloat(d, tnumber);
	}
	
	public static Pointer mult_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.mult_int_tint(i, tnumber);
	}
	
	public static Pointer mult_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.mult_tfloat_float(tnumber, d);
	}
	
	public static Pointer mult_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.mult_tint_int(tnumber, i);
	}
	
	public static Pointer mult_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.mult_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static Pointer sub_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.sub_float_tfloat(d, tnumber);
	}
	
	public static Pointer sub_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.sub_int_tint(i, tnumber);
	}
	
	public static Pointer sub_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.sub_tfloat_float(tnumber, d);
	}
	
	public static Pointer sub_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.sub_tint_int(tnumber, i);
	}
	
	public static Pointer sub_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.sub_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static Pointer tfloat_degrees(Pointer temp) {
		return MeosLibrary.meos.tfloat_degrees(temp);
	}
	
	public static Pointer tfloat_radians(Pointer temp) {
		return MeosLibrary.meos.tfloat_radians(temp);
	}
	
	public static Pointer tfloat_derivative(Pointer temp) {
		return MeosLibrary.meos.tfloat_derivative(temp);
	}
	
	public static Pointer textcat_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.textcat_text_ttext(txt, temp);
	}
	
	public static Pointer textcat_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.textcat_ttext_text(temp, txt);
	}
	
	public static Pointer textcat_ttext_ttext(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.textcat_ttext_ttext(temp1, temp2);
	}
	
	public static Pointer ttext_upper(Pointer temp) {
		return MeosLibrary.meos.ttext_upper(temp);
	}
	
	public static Pointer ttext_lower(Pointer temp) {
		return MeosLibrary.meos.ttext_lower(temp);
	}
	
	public static boolean adjacent_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.adjacent_float_tfloat(d, tnumber);
	}
	
	public static boolean adjacent_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.adjacent_geo_tpoint(geo, tpoint);
	}
	
	public static boolean adjacent_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.adjacent_int_tint(i, tnumber);
	}
	
	public static boolean adjacent_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.adjacent_period_temporal(p, temp);
	}
	
	public static boolean adjacent_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.adjacent_periodset_temporal(ps, temp);
	}
	
	public static boolean adjacent_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.adjacent_span_tnumber(span, tnumber);
	}
	
	public static boolean adjacent_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.adjacent_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean adjacent_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.adjacent_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean adjacent_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.adjacent_temporal_period(temp, p);
	}
	
	public static boolean adjacent_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.adjacent_temporal_periodset(temp, ps);
	}
	
	public static boolean adjacent_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.adjacent_temporal_temporal(temp1, temp2);
	}
	
	public static boolean adjacent_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.adjacent_temporal_timestamp(temp, t);
	}
	
	public static boolean adjacent_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.adjacent_temporal_timestampset(temp, ts);
	}
	
	public static boolean adjacent_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.adjacent_tfloat_float(tnumber, d);
	}
	
	public static boolean adjacent_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.adjacent_timestamp_temporal(t, temp);
	}
	
	public static boolean adjacent_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.adjacent_timestampset_temporal(ts, temp);
	}
	
	public static boolean adjacent_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.adjacent_tint_int(tnumber, i);
	}
	
	public static boolean adjacent_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.adjacent_tnumber_span(tnumber, span);
	}
	
	public static boolean adjacent_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.adjacent_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean adjacent_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.adjacent_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean adjacent_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.adjacent_tpoint_geo(tpoint, geo);
	}
	
	public static boolean adjacent_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.adjacent_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean adjacent_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.adjacent_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean contained_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.contained_float_tfloat(d, tnumber);
	}
	
	public static boolean contained_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.contained_geo_tpoint(geo, tpoint);
	}
	
	public static boolean contained_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.contained_int_tint(i, tnumber);
	}
	
	public static boolean contained_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.contained_period_temporal(p, temp);
	}
	
	public static boolean contained_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.contained_periodset_temporal(ps, temp);
	}
	
	public static boolean contained_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.contained_span_tnumber(span, tnumber);
	}
	
	public static boolean contained_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.contained_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean contained_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.contained_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean contained_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.contained_temporal_period(temp, p);
	}
	
	public static boolean contained_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.contained_temporal_periodset(temp, ps);
	}
	
	public static boolean contained_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.contained_temporal_temporal(temp1, temp2);
	}
	
	public static boolean contained_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.contained_temporal_timestamp(temp, t);
	}
	
	public static boolean contained_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.contained_temporal_timestampset(temp, ts);
	}
	
	public static boolean contained_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.contained_tfloat_float(tnumber, d);
	}
	
	public static boolean contained_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.contained_timestamp_temporal(t, temp);
	}
	
	public static boolean contained_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.contained_timestampset_temporal(ts, temp);
	}
	
	public static boolean contained_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.contained_tint_int(tnumber, i);
	}
	
	public static boolean contained_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.contained_tnumber_span(tnumber, span);
	}
	
	public static boolean contained_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.contained_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean contained_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.contained_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean contained_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.contained_tpoint_geo(tpoint, geo);
	}
	
	public static boolean contained_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.contained_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean contained_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.contained_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean contains_bbox_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.contains_bbox_geo_tpoint(geo, tpoint);
	}
	
	public static boolean contains_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.contains_float_tfloat(d, tnumber);
	}
	
	public static boolean contains_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.contains_int_tint(i, tnumber);
	}
	
	public static boolean contains_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.contains_period_temporal(p, temp);
	}
	
	public static boolean contains_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.contains_periodset_temporal(ps, temp);
	}
	
	public static boolean contains_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.contains_span_tnumber(span, tnumber);
	}
	
	public static boolean contains_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.contains_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean contains_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.contains_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean contains_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.contains_temporal_period(temp, p);
	}
	
	public static boolean contains_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.contains_temporal_periodset(temp, ps);
	}
	
	public static boolean contains_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.contains_temporal_temporal(temp1, temp2);
	}
	
	public static boolean contains_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.contains_temporal_timestamp(temp, t);
	}
	
	public static boolean contains_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.contains_temporal_timestampset(temp, ts);
	}
	
	public static boolean contains_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.contains_tfloat_float(tnumber, d);
	}
	
	public static boolean contains_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.contains_timestamp_temporal(t, temp);
	}
	
	public static boolean contains_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.contains_timestampset_temporal(ts, temp);
	}
	
	public static boolean contains_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.contains_tint_int(tnumber, i);
	}
	
	public static boolean contains_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.contains_tnumber_span(tnumber, span);
	}
	
	public static boolean contains_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.contains_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean contains_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.contains_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean contains_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.contains_tpoint_geo(tpoint, geo);
	}
	
	public static boolean contains_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.contains_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean contains_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.contains_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean left_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.left_float_tfloat(d, tnumber);
	}
	
	public static boolean left_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.left_int_tint(i, tnumber);
	}
	
	public static boolean left_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.left_tfloat_float(tnumber, d);
	}
	
	public static boolean left_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.left_tint_int(tnumber, i);
	}
	
	public static boolean overlaps_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.overlaps_float_tfloat(d, tnumber);
	}
	
	public static boolean overlaps_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overlaps_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overlaps_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.overlaps_int_tint(i, tnumber);
	}
	
	public static boolean overlaps_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.overlaps_period_temporal(p, temp);
	}
	
	public static boolean overlaps_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.overlaps_periodset_temporal(ps, temp);
	}
	
	public static boolean overlaps_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.overlaps_span_tnumber(span, tnumber);
	}
	
	public static boolean overlaps_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overlaps_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overlaps_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.overlaps_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean overlaps_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.overlaps_temporal_period(temp, p);
	}
	
	public static boolean overlaps_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.overlaps_temporal_periodset(temp, ps);
	}
	
	public static boolean overlaps_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.overlaps_temporal_temporal(temp1, temp2);
	}
	
	public static boolean overlaps_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.overlaps_temporal_timestamp(temp, t);
	}
	
	public static boolean overlaps_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.overlaps_temporal_timestampset(temp, ts);
	}
	
	public static boolean overlaps_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.overlaps_tfloat_float(tnumber, d);
	}
	
	public static boolean overlaps_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.overlaps_timestamp_temporal(t, temp);
	}
	
	public static boolean overlaps_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.overlaps_timestampset_temporal(ts, temp);
	}
	
	public static boolean overlaps_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.overlaps_tint_int(tnumber, i);
	}
	
	public static boolean overlaps_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.overlaps_tnumber_span(tnumber, span);
	}
	
	public static boolean overlaps_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.overlaps_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean overlaps_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.overlaps_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean overlaps_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overlaps_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overlaps_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overlaps_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overlaps_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overlaps_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overleft_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.overleft_float_tfloat(d, tnumber);
	}
	
	public static boolean overleft_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.overleft_int_tint(i, tnumber);
	}
	
	public static boolean overleft_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.overleft_tfloat_float(tnumber, d);
	}
	
	public static boolean overleft_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.overleft_tint_int(tnumber, i);
	}
	
	public static boolean overright_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.overright_float_tfloat(d, tnumber);
	}
	
	public static boolean overright_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.overright_int_tint(i, tnumber);
	}
	
	public static boolean overright_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.overright_tfloat_float(tnumber, d);
	}
	
	public static boolean overright_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.overright_tint_int(tnumber, i);
	}
	
	public static boolean right_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.right_float_tfloat(d, tnumber);
	}
	
	public static boolean right_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.right_int_tint(i, tnumber);
	}
	
	public static boolean right_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.right_tfloat_float(tnumber, d);
	}
	
	public static boolean right_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.right_tint_int(tnumber, i);
	}
	
	public static boolean same_float_tfloat(double d, Pointer tnumber) {
		return MeosLibrary.meos.same_float_tfloat(d, tnumber);
	}
	
	public static boolean same_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.same_geo_tpoint(geo, tpoint);
	}
	
	public static boolean same_int_tint(int i, Pointer tnumber) {
		return MeosLibrary.meos.same_int_tint(i, tnumber);
	}
	
	public static boolean same_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.same_period_temporal(p, temp);
	}
	
	public static boolean same_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.same_periodset_temporal(ps, temp);
	}
	
	public static boolean same_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.same_span_tnumber(span, tnumber);
	}
	
	public static boolean same_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.same_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean same_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.same_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean same_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.same_temporal_period(temp, p);
	}
	
	public static boolean same_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.same_temporal_periodset(temp, ps);
	}
	
	public static boolean same_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.same_temporal_temporal(temp1, temp2);
	}
	
	public static boolean same_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.same_temporal_timestamp(temp, t);
	}
	
	public static boolean same_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.same_temporal_timestampset(temp, ts);
	}
	
	public static boolean same_tfloat_float(Pointer tnumber, double d) {
		return MeosLibrary.meos.same_tfloat_float(tnumber, d);
	}
	
	public static boolean same_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.same_timestamp_temporal(t, temp);
	}
	
	public static boolean same_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.same_timestampset_temporal(ts, temp);
	}
	
	public static boolean same_tint_int(Pointer tnumber, int i) {
		return MeosLibrary.meos.same_tint_int(tnumber, i);
	}
	
	public static boolean same_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.same_tnumber_span(tnumber, span);
	}
	
	public static boolean same_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.same_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean same_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.same_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean same_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.same_tpoint_geo(tpoint, geo);
	}
	
	public static boolean same_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.same_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean same_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.same_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean above_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.above_geo_tpoint(geo, tpoint);
	}
	
	public static boolean above_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.above_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean above_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.above_tpoint_geo(tpoint, geo);
	}
	
	public static boolean above_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.above_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean above_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.above_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean after_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.after_period_temporal(p, temp);
	}
	
	public static boolean after_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.after_periodset_temporal(ps, temp);
	}
	
	public static boolean after_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.after_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean after_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.after_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean after_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.after_temporal_period(temp, p);
	}
	
	public static boolean after_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.after_temporal_periodset(temp, ps);
	}
	
	public static boolean after_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.after_temporal_temporal(temp1, temp2);
	}
	
	public static boolean after_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.after_temporal_timestamp(temp, t);
	}
	
	public static boolean after_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.after_temporal_timestampset(temp, ts);
	}
	
	public static boolean after_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.after_timestamp_temporal(t, temp);
	}
	
	public static boolean after_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.after_timestampset_temporal(ts, temp);
	}
	
	public static boolean after_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.after_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean after_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.after_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean after_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.after_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean after_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.after_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean back_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.back_geo_tpoint(geo, tpoint);
	}
	
	public static boolean back_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.back_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean back_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.back_tpoint_geo(tpoint, geo);
	}
	
	public static boolean back_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.back_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean back_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.back_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean before_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.before_period_temporal(p, temp);
	}
	
	public static boolean before_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.before_periodset_temporal(ps, temp);
	}
	
	public static boolean before_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.before_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean before_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.before_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean before_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.before_temporal_period(temp, p);
	}
	
	public static boolean before_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.before_temporal_periodset(temp, ps);
	}
	
	public static boolean before_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.before_temporal_temporal(temp1, temp2);
	}
	
	public static boolean before_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.before_temporal_timestamp(temp, t);
	}
	
	public static boolean before_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.before_temporal_timestampset(temp, ts);
	}
	
	public static boolean before_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.before_timestamp_temporal(t, temp);
	}
	
	public static boolean before_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.before_timestampset_temporal(ts, temp);
	}
	
	public static boolean before_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.before_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean before_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.before_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean before_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.before_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean before_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.before_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean below_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.below_geo_tpoint(geo, tpoint);
	}
	
	public static boolean below_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.below_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean below_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.below_tpoint_geo(tpoint, geo);
	}
	
	public static boolean below_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.below_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean below_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.below_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean front_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.front_geo_tpoint(geo, tpoint);
	}
	
	public static boolean front_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.front_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean front_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.front_tpoint_geo(tpoint, geo);
	}
	
	public static boolean front_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.front_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean front_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.front_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean left_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.left_geo_tpoint(geo, tpoint);
	}
	
	public static boolean left_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.left_span_tnumber(span, tnumber);
	}
	
	public static boolean left_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.left_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean left_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.left_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean left_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.left_tnumber_span(tnumber, span);
	}
	
	public static boolean left_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.left_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean left_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.left_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean left_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.left_tpoint_geo(tpoint, geo);
	}
	
	public static boolean left_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.left_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean left_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.left_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overabove_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overabove_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overabove_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overabove_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overabove_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overabove_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overabove_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overabove_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overabove_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overabove_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overafter_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.overafter_period_temporal(p, temp);
	}
	
	public static boolean overafter_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.overafter_periodset_temporal(ps, temp);
	}
	
	public static boolean overafter_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overafter_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overafter_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.overafter_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean overafter_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.overafter_temporal_period(temp, p);
	}
	
	public static boolean overafter_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.overafter_temporal_periodset(temp, ps);
	}
	
	public static boolean overafter_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.overafter_temporal_temporal(temp1, temp2);
	}
	
	public static boolean overafter_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.overafter_temporal_timestamp(temp, t);
	}
	
	public static boolean overafter_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.overafter_temporal_timestampset(temp, ts);
	}
	
	public static boolean overafter_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.overafter_timestamp_temporal(t, temp);
	}
	
	public static boolean overafter_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.overafter_timestampset_temporal(ts, temp);
	}
	
	public static boolean overafter_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.overafter_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean overafter_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.overafter_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean overafter_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overafter_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overafter_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overafter_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overback_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overback_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overback_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overback_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overback_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overback_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overback_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overback_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overback_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overback_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overbefore_period_temporal(Pointer p, Pointer temp) {
		return MeosLibrary.meos.overbefore_period_temporal(p, temp);
	}
	
	public static boolean overbefore_periodset_temporal(Pointer ps, Pointer temp) {
		return MeosLibrary.meos.overbefore_periodset_temporal(ps, temp);
	}
	
	public static boolean overbefore_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overbefore_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overbefore_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.overbefore_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean overbefore_temporal_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.overbefore_temporal_period(temp, p);
	}
	
	public static boolean overbefore_temporal_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.overbefore_temporal_periodset(temp, ps);
	}
	
	public static boolean overbefore_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.overbefore_temporal_temporal(temp1, temp2);
	}
	
	public static boolean overbefore_temporal_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.overbefore_temporal_timestamp(temp, t);
	}
	
	public static boolean overbefore_temporal_timestampset(Pointer temp, Pointer ts) {
		return MeosLibrary.meos.overbefore_temporal_timestampset(temp, ts);
	}
	
	public static boolean overbefore_timestamp_temporal(int t, Pointer temp) {
		return MeosLibrary.meos.overbefore_timestamp_temporal(t, temp);
	}
	
	public static boolean overbefore_timestampset_temporal(Pointer ts, Pointer temp) {
		return MeosLibrary.meos.overbefore_timestampset_temporal(ts, temp);
	}
	
	public static boolean overbefore_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.overbefore_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean overbefore_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.overbefore_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean overbefore_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overbefore_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overbefore_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overbefore_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overbelow_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overbelow_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overbelow_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overbelow_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overbelow_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overbelow_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overbelow_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overbelow_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overbelow_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overbelow_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overfront_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overfront_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overfront_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overfront_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overfront_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overfront_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overfront_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overfront_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overfront_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overfront_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overleft_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overleft_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overleft_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.overleft_span_tnumber(span, tnumber);
	}
	
	public static boolean overleft_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overleft_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overleft_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.overleft_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean overleft_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.overleft_tnumber_span(tnumber, span);
	}
	
	public static boolean overleft_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.overleft_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean overleft_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.overleft_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean overleft_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overleft_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overleft_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overleft_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overleft_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overleft_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean overright_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.overright_geo_tpoint(geo, tpoint);
	}
	
	public static boolean overright_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.overright_span_tnumber(span, tnumber);
	}
	
	public static boolean overright_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.overright_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean overright_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.overright_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean overright_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.overright_tnumber_span(tnumber, span);
	}
	
	public static boolean overright_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.overright_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean overright_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.overright_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean overright_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.overright_tpoint_geo(tpoint, geo);
	}
	
	public static boolean overright_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.overright_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean overright_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.overright_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static boolean right_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.right_geo_tpoint(geo, tpoint);
	}
	
	public static boolean right_span_tnumber(Pointer span, Pointer tnumber) {
		return MeosLibrary.meos.right_span_tnumber(span, tnumber);
	}
	
	public static boolean right_stbox_tpoint(Pointer stbox, Pointer tpoint) {
		return MeosLibrary.meos.right_stbox_tpoint(stbox, tpoint);
	}
	
	public static boolean right_tbox_tnumber(Pointer tbox, Pointer tnumber) {
		return MeosLibrary.meos.right_tbox_tnumber(tbox, tnumber);
	}
	
	public static boolean right_tnumber_span(Pointer tnumber, Pointer span) {
		return MeosLibrary.meos.right_tnumber_span(tnumber, span);
	}
	
	public static boolean right_tnumber_tbox(Pointer tnumber, Pointer tbox) {
		return MeosLibrary.meos.right_tnumber_tbox(tnumber, tbox);
	}
	
	public static boolean right_tnumber_tnumber(Pointer tnumber1, Pointer tnumber2) {
		return MeosLibrary.meos.right_tnumber_tnumber(tnumber1, tnumber2);
	}
	
	public static boolean right_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.right_tpoint_geo(tpoint, geo);
	}
	
	public static boolean right_tpoint_stbox(Pointer tpoint, Pointer stbox) {
		return MeosLibrary.meos.right_tpoint_stbox(tpoint, stbox);
	}
	
	public static boolean right_tpoint_tpoint(Pointer tpoint1, Pointer tpoint2) {
		return MeosLibrary.meos.right_tpoint_tpoint(tpoint1, tpoint2);
	}
	
	public static Pointer distance_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.distance_tfloat_float(temp, d);
	}
	
	public static Pointer distance_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.distance_tint_int(temp, i);
	}
	
	public static Pointer distance_tnumber_tnumber(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.distance_tnumber_tnumber(temp1, temp2);
	}
	
	public static Pointer distance_tpoint_geo(Pointer temp, Pointer geo) {
		return MeosLibrary.meos.distance_tpoint_geo(temp, geo);
	}
	
	public static Pointer distance_tpoint_tpoint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.distance_tpoint_tpoint(temp1, temp2);
	}
	
	public static double nad_stbox_geo(Pointer box, Pointer gs) {
		return MeosLibrary.meos.nad_stbox_geo(box, gs);
	}
	
	public static double nad_stbox_stbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.nad_stbox_stbox(box1, box2);
	}
	
	public static double nad_tbox_tbox(Pointer box1, Pointer box2) {
		return MeosLibrary.meos.nad_tbox_tbox(box1, box2);
	}
	
	public static double nad_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.nad_tfloat_float(temp, d);
	}
	
	public static double nad_tfloat_tfloat(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.nad_tfloat_tfloat(temp1, temp2);
	}
	
	public static int nad_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.nad_tint_int(temp, i);
	}
	
	public static int nad_tint_tint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.nad_tint_tint(temp1, temp2);
	}
	
	public static double nad_tnumber_tbox(Pointer temp, Pointer box) {
		return MeosLibrary.meos.nad_tnumber_tbox(temp, box);
	}
	
	public static double nad_tpoint_geo(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.nad_tpoint_geo(temp, gs);
	}
	
	public static double nad_tpoint_stbox(Pointer temp, Pointer box) {
		return MeosLibrary.meos.nad_tpoint_stbox(temp, box);
	}
	
	public static double nad_tpoint_tpoint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.nad_tpoint_tpoint(temp1, temp2);
	}
	
	public static Pointer nai_tpoint_geo(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.nai_tpoint_geo(temp, gs);
	}
	
	public static Pointer nai_tpoint_tpoint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.nai_tpoint_tpoint(temp1, temp2);
	}
	
	public static boolean shortestline_tpoint_geo(Pointer temp, Pointer gs, Pointer[] result) {
		return MeosLibrary.meos.shortestline_tpoint_geo(temp, gs, result);
	}
	
	public static boolean shortestline_tpoint_tpoint(Pointer temp1, Pointer temp2, Pointer[] result) {
		return MeosLibrary.meos.shortestline_tpoint_tpoint(temp1, temp2, result);
	}
	
	public static boolean tbool_always_eq(Pointer temp, boolean b) {
		return MeosLibrary.meos.tbool_always_eq(temp, b);
	}
	
	public static boolean tbool_ever_eq(Pointer temp, boolean b) {
		return MeosLibrary.meos.tbool_ever_eq(temp, b);
	}
	
	public static boolean tfloat_always_eq(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_always_eq(temp, d);
	}
	
	public static boolean tfloat_always_le(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_always_le(temp, d);
	}
	
	public static boolean tfloat_always_lt(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_always_lt(temp, d);
	}
	
	public static boolean tfloat_ever_eq(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_ever_eq(temp, d);
	}
	
	public static boolean tfloat_ever_le(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_ever_le(temp, d);
	}
	
	public static boolean tfloat_ever_lt(Pointer temp, double d) {
		return MeosLibrary.meos.tfloat_ever_lt(temp, d);
	}
	
	public static boolean tgeogpoint_always_eq(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tgeogpoint_always_eq(temp, gs);
	}
	
	public static boolean tgeogpoint_ever_eq(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tgeogpoint_ever_eq(temp, gs);
	}
	
	public static boolean tgeompoint_always_eq(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tgeompoint_always_eq(temp, gs);
	}
	
	public static boolean tgeompoint_ever_eq(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tgeompoint_ever_eq(temp, gs);
	}
	
	public static boolean tint_always_eq(Pointer temp, int i) {
		return MeosLibrary.meos.tint_always_eq(temp, i);
	}
	
	public static boolean tint_always_le(Pointer temp, int i) {
		return MeosLibrary.meos.tint_always_le(temp, i);
	}
	
	public static boolean tint_always_lt(Pointer temp, int i) {
		return MeosLibrary.meos.tint_always_lt(temp, i);
	}
	
	public static boolean tint_ever_eq(Pointer temp, int i) {
		return MeosLibrary.meos.tint_ever_eq(temp, i);
	}
	
	public static boolean tint_ever_le(Pointer temp, int i) {
		return MeosLibrary.meos.tint_ever_le(temp, i);
	}
	
	public static boolean tint_ever_lt(Pointer temp, int i) {
		return MeosLibrary.meos.tint_ever_lt(temp, i);
	}
	
	public static boolean ttext_always_eq(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_always_eq(temp, txt);
	}
	
	public static boolean ttext_always_le(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_always_le(temp, txt);
	}
	
	public static boolean ttext_always_lt(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_always_lt(temp, txt);
	}
	
	public static boolean ttext_ever_eq(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_ever_eq(temp, txt);
	}
	
	public static boolean ttext_ever_le(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_ever_le(temp, txt);
	}
	
	public static boolean ttext_ever_lt(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.ttext_ever_lt(temp, txt);
	}
	
	public static int temporal_cmp(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_cmp(temp1, temp2);
	}
	
	public static boolean temporal_eq(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_eq(temp1, temp2);
	}
	
	public static boolean temporal_ge(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_ge(temp1, temp2);
	}
	
	public static boolean temporal_gt(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_gt(temp1, temp2);
	}
	
	public static boolean temporal_le(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_le(temp1, temp2);
	}
	
	public static boolean temporal_lt(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_lt(temp1, temp2);
	}
	
	public static boolean temporal_ne(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_ne(temp1, temp2);
	}
	
	public static Pointer teq_bool_tbool(boolean b, Pointer temp) {
		return MeosLibrary.meos.teq_bool_tbool(b, temp);
	}
	
	public static Pointer teq_float_tfloat(double d, Pointer temp) {
		return MeosLibrary.meos.teq_float_tfloat(d, temp);
	}
	
	public static Pointer teq_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.teq_geo_tpoint(geo, tpoint);
	}
	
	public static Pointer teq_int_tint(int i, Pointer temp) {
		return MeosLibrary.meos.teq_int_tint(i, temp);
	}
	
	public static Pointer teq_point_tgeogpoint(Pointer gs, Pointer temp) {
		return MeosLibrary.meos.teq_point_tgeogpoint(gs, temp);
	}
	
	public static Pointer teq_point_tgeompoint(Pointer gs, Pointer temp) {
		return MeosLibrary.meos.teq_point_tgeompoint(gs, temp);
	}
	
	public static Pointer teq_tbool_bool(Pointer temp, boolean b) {
		return MeosLibrary.meos.teq_tbool_bool(temp, b);
	}
	
	public static Pointer teq_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.teq_temporal_temporal(temp1, temp2);
	}
	
	public static Pointer teq_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.teq_text_ttext(txt, temp);
	}
	
	public static Pointer teq_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.teq_tfloat_float(temp, d);
	}
	
	public static Pointer teq_tgeogpoint_point(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.teq_tgeogpoint_point(temp, gs);
	}
	
	public static Pointer teq_tgeompoint_point(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.teq_tgeompoint_point(temp, gs);
	}
	
	public static Pointer teq_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.teq_tint_int(temp, i);
	}
	
	public static Pointer teq_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.teq_tpoint_geo(tpoint, geo);
	}
	
	public static Pointer teq_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.teq_ttext_text(temp, txt);
	}
	
	public static Pointer tge_float_tfloat(double d, Pointer temp) {
		return MeosLibrary.meos.tge_float_tfloat(d, temp);
	}
	
	public static Pointer tge_int_tint(int i, Pointer temp) {
		return MeosLibrary.meos.tge_int_tint(i, temp);
	}
	
	public static Pointer tge_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tge_temporal_temporal(temp1, temp2);
	}
	
	public static Pointer tge_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.tge_text_ttext(txt, temp);
	}
	
	public static Pointer tge_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.tge_tfloat_float(temp, d);
	}
	
	public static Pointer tge_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.tge_tint_int(temp, i);
	}
	
	public static Pointer tge_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.tge_ttext_text(temp, txt);
	}
	
	public static Pointer tgt_float_tfloat(double d, Pointer temp) {
		return MeosLibrary.meos.tgt_float_tfloat(d, temp);
	}
	
	public static Pointer tgt_int_tint(int i, Pointer temp) {
		return MeosLibrary.meos.tgt_int_tint(i, temp);
	}
	
	public static Pointer tgt_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tgt_temporal_temporal(temp1, temp2);
	}
	
	public static Pointer tgt_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.tgt_text_ttext(txt, temp);
	}
	
	public static Pointer tgt_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.tgt_tfloat_float(temp, d);
	}
	
	public static Pointer tgt_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.tgt_tint_int(temp, i);
	}
	
	public static Pointer tgt_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.tgt_ttext_text(temp, txt);
	}
	
	public static Pointer tle_float_tfloat(double d, Pointer temp) {
		return MeosLibrary.meos.tle_float_tfloat(d, temp);
	}
	
	public static Pointer tle_int_tint(int i, Pointer temp) {
		return MeosLibrary.meos.tle_int_tint(i, temp);
	}
	
	public static Pointer tle_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tle_temporal_temporal(temp1, temp2);
	}
	
	public static Pointer tle_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.tle_text_ttext(txt, temp);
	}
	
	public static Pointer tle_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.tle_tfloat_float(temp, d);
	}
	
	public static Pointer tle_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.tle_tint_int(temp, i);
	}
	
	public static Pointer tle_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.tle_ttext_text(temp, txt);
	}
	
	public static Pointer tlt_float_tfloat(double d, Pointer temp) {
		return MeosLibrary.meos.tlt_float_tfloat(d, temp);
	}
	
	public static Pointer tlt_int_tint(int i, Pointer temp) {
		return MeosLibrary.meos.tlt_int_tint(i, temp);
	}
	
	public static Pointer tlt_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tlt_temporal_temporal(temp1, temp2);
	}
	
	public static Pointer tlt_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.tlt_text_ttext(txt, temp);
	}
	
	public static Pointer tlt_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.tlt_tfloat_float(temp, d);
	}
	
	public static Pointer tlt_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.tlt_tint_int(temp, i);
	}
	
	public static Pointer tlt_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.tlt_ttext_text(temp, txt);
	}
	
	public static Pointer tne_bool_tbool(boolean b, Pointer temp) {
		return MeosLibrary.meos.tne_bool_tbool(b, temp);
	}
	
	public static Pointer tne_float_tfloat(double d, Pointer temp) {
		return MeosLibrary.meos.tne_float_tfloat(d, temp);
	}
	
	public static Pointer tne_geo_tpoint(Pointer geo, Pointer tpoint) {
		return MeosLibrary.meos.tne_geo_tpoint(geo, tpoint);
	}
	
	public static Pointer tne_int_tint(int i, Pointer temp) {
		return MeosLibrary.meos.tne_int_tint(i, temp);
	}
	
	public static Pointer tne_point_tgeogpoint(Pointer gs, Pointer temp) {
		return MeosLibrary.meos.tne_point_tgeogpoint(gs, temp);
	}
	
	public static Pointer tne_point_tgeompoint(Pointer gs, Pointer temp) {
		return MeosLibrary.meos.tne_point_tgeompoint(gs, temp);
	}
	
	public static Pointer tne_tbool_bool(Pointer temp, boolean b) {
		return MeosLibrary.meos.tne_tbool_bool(temp, b);
	}
	
	public static Pointer tne_temporal_temporal(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.tne_temporal_temporal(temp1, temp2);
	}
	
	public static Pointer tne_text_ttext(Pointer txt, Pointer temp) {
		return MeosLibrary.meos.tne_text_ttext(txt, temp);
	}
	
	public static Pointer tne_tfloat_float(Pointer temp, double d) {
		return MeosLibrary.meos.tne_tfloat_float(temp, d);
	}
	
	public static Pointer tne_tgeogpoint_point(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tne_tgeogpoint_point(temp, gs);
	}
	
	public static Pointer tne_tgeompoint_point(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.tne_tgeompoint_point(temp, gs);
	}
	
	public static Pointer tne_tint_int(Pointer temp, int i) {
		return MeosLibrary.meos.tne_tint_int(temp, i);
	}
	
	public static Pointer tne_tpoint_geo(Pointer tpoint, Pointer geo) {
		return MeosLibrary.meos.tne_tpoint_geo(tpoint, geo);
	}
	
	public static Pointer tne_ttext_text(Pointer temp, Pointer txt) {
		return MeosLibrary.meos.tne_ttext_text(temp, txt);
	}
	
	public static boolean bearing_point_point(Pointer geo1, Pointer geo2, Pointer result) {
		return MeosLibrary.meos.bearing_point_point(geo1, geo2, result);
	}
	
	public static Pointer bearing_tpoint_point(Pointer temp, Pointer gs, boolean invert) {
		return MeosLibrary.meos.bearing_tpoint_point(temp, gs, invert);
	}
	
	public static Pointer bearing_tpoint_tpoint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.bearing_tpoint_tpoint(temp1, temp2);
	}
	
	public static Pointer tpoint_azimuth(Pointer temp) {
		return MeosLibrary.meos.tpoint_azimuth(temp);
	}
	
	public static Pointer tpoint_cumulative_length(Pointer temp) {
		return MeosLibrary.meos.tpoint_cumulative_length(temp);
	}
	
	public static Pointer tpoint_get_coord(Pointer temp, int coord) {
		return MeosLibrary.meos.tpoint_get_coord(temp, coord);
	}
	
	public static boolean tpoint_is_simple(Pointer temp) {
		return MeosLibrary.meos.tpoint_is_simple(temp);
	}
	
	public static double tpoint_length(Pointer temp) {
		return MeosLibrary.meos.tpoint_length(temp);
	}
	
	public static Pointer tpoint_speed(Pointer temp) {
		return MeosLibrary.meos.tpoint_speed(temp);
	}
	
	public static int tpoint_srid(Pointer temp) {
		return MeosLibrary.meos.tpoint_srid(temp);
	}
	
	public static Pointer tpoint_stboxes(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tpoint_stboxes(temp, count);
	}
	
	public static Pointer tpoint_trajectory(Pointer temp) {
		return MeosLibrary.meos.tpoint_trajectory(temp);
	}
	
	public static Pointer geo_expand_spatial(Pointer gs, double d) {
		return MeosLibrary.meos.geo_expand_spatial(gs, d);
	}
	
	public static Pointer tgeompoint_tgeogpoint(Pointer temp, boolean oper) {
		return MeosLibrary.meos.tgeompoint_tgeogpoint(temp, oper);
	}
	
	public static Pointer tpoint_expand_spatial(Pointer temp, double d) {
		return MeosLibrary.meos.tpoint_expand_spatial(temp, d);
	}
	
	public static Pointer[] tpoint_make_simple(Pointer temp, Pointer count) {
		return MeosLibrary.meos.tpoint_make_simple(temp, count);
	}
	
	public static Pointer tpoint_set_srid(Pointer temp, int32_t srid) {
		return MeosLibrary.meos.tpoint_set_srid(temp, srid);
	}
	
	public static int contains_geo_tpoint(Pointer geo, Pointer temp) {
		return MeosLibrary.meos.contains_geo_tpoint(geo, temp);
	}
	
	public static int disjoint_tpoint_geo(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.disjoint_tpoint_geo(temp, gs);
	}
	
	public static int disjoint_tpoint_tpoint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.disjoint_tpoint_tpoint(temp1, temp2);
	}
	
	public static int dwithin_tpoint_geo(Pointer temp, Pointer gs, double dist) {
		return MeosLibrary.meos.dwithin_tpoint_geo(temp, gs, dist);
	}
	
	public static int dwithin_tpoint_tpoint(Pointer temp1, Pointer temp2, double dist) {
		return MeosLibrary.meos.dwithin_tpoint_tpoint(temp1, temp2, dist);
	}
	
	public static int intersects_tpoint_geo(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.intersects_tpoint_geo(temp, gs);
	}
	
	public static int intersects_tpoint_tpoint(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.intersects_tpoint_tpoint(temp1, temp2);
	}
	
	public static Pointer tcontains_geo_tpoint(Pointer gs, Pointer temp, boolean restr, boolean atvalue) {
		return MeosLibrary.meos.tcontains_geo_tpoint(gs, temp, restr, atvalue);
	}
	
	public static Pointer tdisjoint_tpoint_geo(Pointer temp, Pointer geo, boolean restr, boolean atvalue) {
		return MeosLibrary.meos.tdisjoint_tpoint_geo(temp, geo, restr, atvalue);
	}
	
	public static Pointer tdwithin_tpoint_geo(Pointer temp, Pointer gs, double dist, boolean restr, boolean atvalue) {
		return MeosLibrary.meos.tdwithin_tpoint_geo(temp, gs, dist, restr, atvalue);
	}
	
	public static Pointer tdwithin_tpoint_tpoint(Pointer temp1, Pointer temp2, double dist, boolean restr, boolean atvalue) {
		return MeosLibrary.meos.tdwithin_tpoint_tpoint(temp1, temp2, dist, restr, atvalue);
	}
	
	public static Pointer tintersects_tpoint_geo(Pointer temp, Pointer geo, boolean restr, boolean atvalue) {
		return MeosLibrary.meos.tintersects_tpoint_geo(temp, geo, restr, atvalue);
	}
	
	public static int touches_tpoint_geo(Pointer temp, Pointer gs) {
		return MeosLibrary.meos.touches_tpoint_geo(temp, gs);
	}
	
	public static Pointer ttouches_tpoint_geo(Pointer temp, Pointer gs, boolean restr, boolean atvalue) {
		return MeosLibrary.meos.ttouches_tpoint_geo(temp, gs, restr, atvalue);
	}
	
	public static Pointer temporal_insert(Pointer temp1, Pointer temp2, boolean connect) {
		return MeosLibrary.meos.temporal_insert(temp1, temp2, connect);
	}
	
	public static Pointer temporal_update(Pointer temp1, Pointer temp2, boolean connect) {
		return MeosLibrary.meos.temporal_update(temp1, temp2, connect);
	}
	
	public static Pointer temporal_delete_timestamp(Pointer temp, int t, boolean connect) {
		return MeosLibrary.meos.temporal_delete_timestamp(temp, t, connect);
	}
	
	public static Pointer temporal_delete_timestampset(Pointer temp, Pointer ts, boolean connect) {
		return MeosLibrary.meos.temporal_delete_timestampset(temp, ts, connect);
	}
	
	public static Pointer temporal_delete_period(Pointer temp, Pointer p, boolean connect) {
		return MeosLibrary.meos.temporal_delete_period(temp, p, connect);
	}
	
	public static Pointer temporal_delete_periodset(Pointer temp, Pointer ps, boolean connect) {
		return MeosLibrary.meos.temporal_delete_periodset(temp, ps, connect);
	}
	
	public static boolean temporal_intersects_period(Pointer temp, Pointer p) {
		return MeosLibrary.meos.temporal_intersects_period(temp, p);
	}
	
	public static boolean temporal_intersects_periodset(Pointer temp, Pointer ps) {
		return MeosLibrary.meos.temporal_intersects_periodset(temp, ps);
	}
	
	public static boolean temporal_intersects_timestamp(Pointer temp, int t) {
		return MeosLibrary.meos.temporal_intersects_timestamp(temp, t);
	}
	
	public static boolean temporal_intersects_timestampset(Pointer temp, Pointer ss) {
		return MeosLibrary.meos.temporal_intersects_timestampset(temp, ss);
	}
	
	public static double tnumber_integral(Pointer temp) {
		return MeosLibrary.meos.tnumber_integral(temp);
	}
	
	public static double tnumber_twavg(Pointer temp) {
		return MeosLibrary.meos.tnumber_twavg(temp);
	}
	
	public static Pointer tpoint_twcentroid(Pointer temp) {
		return MeosLibrary.meos.tpoint_twcentroid(temp);
	}
	
	public static void skiplist_free(Pointer list) {
		MeosLibrary.meos.skiplist_free(list);
	}
	
	public static Pointer temporal_extent_transfn(Pointer p, Pointer temp) {
		return MeosLibrary.meos.temporal_extent_transfn(p, temp);
	}
	
	public static Pointer tnumber_extent_transfn(Pointer box, Pointer temp) {
		return MeosLibrary.meos.tnumber_extent_transfn(box, temp);
	}
	
	public static Pointer tpoint_extent_transfn(Pointer box, Pointer temp) {
		return MeosLibrary.meos.tpoint_extent_transfn(box, temp);
	}
	
	public static Pointer temporal_tcount_transfn(Pointer state, Pointer temp, Pointer interval, int origin) {
		return MeosLibrary.meos.temporal_tcount_transfn(state, temp, interval, origin);
	}
	
	public static Pointer tbool_tand_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tbool_tand_transfn(state, temp);
	}
	
	public static Pointer tbool_tor_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tbool_tor_transfn(state, temp);
	}
	
	public static Pointer tint_tmin_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tint_tmin_transfn(state, temp);
	}
	
	public static Pointer tfloat_tmin_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tfloat_tmin_transfn(state, temp);
	}
	
	public static Pointer tint_tmax_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tint_tmax_transfn(state, temp);
	}
	
	public static Pointer tfloat_tmax_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tfloat_tmax_transfn(state, temp);
	}
	
	public static Pointer tint_tsum_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tint_tsum_transfn(state, temp);
	}
	
	public static Pointer tfloat_tsum_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tfloat_tsum_transfn(state, temp);
	}
	
	public static Pointer tnumber_tavg_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.tnumber_tavg_transfn(state, temp);
	}
	
	public static Pointer ttext_tmin_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.ttext_tmin_transfn(state, temp);
	}
	
	public static Pointer ttext_tmax_transfn(Pointer state, Pointer temp) {
		return MeosLibrary.meos.ttext_tmax_transfn(state, temp);
	}
	
	public static Pointer temporal_tagg_finalfn(Pointer state) {
		return MeosLibrary.meos.temporal_tagg_finalfn(state);
	}
	
	public static Pointer tnumber_tavg_finalfn(Pointer state) {
		return MeosLibrary.meos.tnumber_tavg_finalfn(state);
	}
	
	public static int int_bucket(int value, int size, int origin) {
		return MeosLibrary.meos.int_bucket(value, size, origin);
	}
	
	public static double float_bucket(double value, double size, double origin) {
		return MeosLibrary.meos.float_bucket(value, size, origin);
	}
	
	public static int timestamptz_bucket(int timestamp, Pointer duration, int origin) {
		return MeosLibrary.meos.timestamptz_bucket(timestamp, duration, origin);
	}
	
	public static Pointer intspan_bucket_list(Pointer bounds, int size, int origin, Pointer newcount) {
		return MeosLibrary.meos.intspan_bucket_list(bounds, size, origin, newcount);
	}
	
	public static Pointer floatspan_bucket_list(Pointer bounds, double size, double origin, Pointer newcount) {
		return MeosLibrary.meos.floatspan_bucket_list(bounds, size, origin, newcount);
	}
	
	public static Pointer period_bucket_list(Pointer bounds, Pointer duration, int origin, Pointer newcount) {
		return MeosLibrary.meos.period_bucket_list(bounds, duration, origin, newcount);
	}
	
	public static Pointer tbox_tile_list(Pointer bounds, double xsize, Pointer duration, double xorigin, int torigin, Pointer rows, Pointer columns) {
		return MeosLibrary.meos.tbox_tile_list(bounds, xsize, duration, xorigin, torigin, rows, columns);
	}
	
	public static Pointer[] tint_value_split(Pointer temp, int size, int origin, Pointer newcount) {
		return MeosLibrary.meos.tint_value_split(temp, size, origin, newcount);
	}
	
	public static Pointer[] tfloat_value_split(Pointer temp, double size, double origin, Pointer newcount) {
		return MeosLibrary.meos.tfloat_value_split(temp, size, origin, newcount);
	}
	
	public static Pointer[] temporal_time_split(Pointer temp, Pointer duration, int torigin, Pointer newcount) {
		return MeosLibrary.meos.temporal_time_split(temp, duration, torigin, newcount);
	}
	
	public static Pointer[] tint_value_time_split(Pointer temp, int size, int vorigin, Pointer duration, int torigin, Pointer newcount) {
		return MeosLibrary.meos.tint_value_time_split(temp, size, vorigin, duration, torigin, newcount);
	}
	
	public static Pointer[] tfloat_value_time_split(Pointer temp, double size, double vorigin, Pointer duration, int torigin, Pointer newcount) {
		return MeosLibrary.meos.tfloat_value_time_split(temp, size, vorigin, duration, torigin, newcount);
	}
	
	public static Pointer stbox_tile_list(Pointer bounds, double size, Pointer duration, Pointer sorigin, int torigin, Pointer[] cellcount) {
		return MeosLibrary.meos.stbox_tile_list(bounds, size, duration, sorigin, torigin, cellcount);
	}
	
	public static double temporal_frechet_distance(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_frechet_distance(temp1, temp2);
	}
	
	public static double temporal_dyntimewarp_distance(Pointer temp1, Pointer temp2) {
		return MeosLibrary.meos.temporal_dyntimewarp_distance(temp1, temp2);
	}
	
	public static Pointer temporal_frechet_path(Pointer temp1, Pointer temp2, Pointer count) {
		return MeosLibrary.meos.temporal_frechet_path(temp1, temp2, count);
	}
	
	public static Pointer temporal_dyntimewarp_path(Pointer temp1, Pointer temp2, Pointer count) {
		return MeosLibrary.meos.temporal_dyntimewarp_path(temp1, temp2, count);
	}
	
	public static Pointer geo_to_tpoint(Pointer geo) {
		return MeosLibrary.meos.geo_to_tpoint(geo);
	}
	
	public static Pointer temporal_simplify(Pointer temp, double eps_dist, boolean synchronize) {
		return MeosLibrary.meos.temporal_simplify(temp, eps_dist, synchronize);
	}
	
	public static boolean tpoint_to_geo_measure(Pointer tpoint, Pointer measure, boolean segmentize, Pointer[] result) {
		return MeosLibrary.meos.tpoint_to_geo_measure(tpoint, measure, segmentize, result);
	}
}