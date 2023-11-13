package types.collections.text;

import jnr.ffi.Pointer;
import types.collections.base.Base;
import types.collections.base.Set;
import types.collections.base.Collection;
import functions.functions;
import types.collections.base.SpanSet;
import types.collections.base.Span;

import java.util.List;


/**
 * Class for representing a set of text values.
 * <p>
 *     "TextSet" objects can be created with a single argument of type string as
 *     in MobilityDB.
 *  <p>
 *         >>> TextSet(string='{a, b, c, def}')
 * <p>
 *     Another possibility is to create a ``TextSet`` object from a list of strings.
 * <p>
 *         >>> TextSet(elements=['a', 'b', 'c', 'def'])
 */
public class TextSet extends Set<String> {
    Pointer _inner;



    /** ------------------------- Constructors ---------------------------------- */

    public TextSet(String str){
        _inner = functions.textset_in(str);
    }

    public TextSet(Pointer inner){
        _inner = inner;
    }

    /** ------------------------- Output ---------------------------------------- */

    /**
     * Return the string representation of the content of ``self``.
     *
     * <p>
     *
     *         MEOS Functions:
     *             <li>textset_out</li>
     *
     * @return A new {@link String} instance
     */
    public String toString(){
        return functions.textset_out(this._inner);
    }


    /** ------------------------- Accessors ------------------------------------- */

    public Pointer get_inner(){
        return this._inner;
    }

    /**
     * Returns the first element in "this".
     *
     *  <p>
     *         MEOS Functions:
     *             <li>textset_start_value</li>
     *
     * @return A {@link String} instance
     */
    public String start_element() {
        return new TextSet(functions.textset_start_value(this._inner)).toString();
    }

    /**
     * Returns the last element in "this".
     *
     *  <p>
     *         MEOS Functions:
     *             <li>textset_end_value</li>
     *
     * @return A {@link String} instance
     */
    public String end_element(){
        return new TextSet(functions.textset_end_value(this._inner)).toString();
    }

    /**
     * Returns the "n"-th element in "this".
     *
     *  <p>
     *
     *         MEOS Functions:
     *             <li>textset_value_n</li>
     *
     * @param n The 0-based index of the element to return.
     * @return A {@link String} instance
     * @throws Exception
     */
    public String element_n(int n) throws Exception {
        Pointer result = null;
        super.element_n(n);
        return "";
        //return new TextSet(functions.text2cstring(functions.textset_value_n(this._inner, n+1, result))).toString();
    }

    /** ------------------------- Topological Operations -------------------------------- */

    /**
     * Returns whether "this" contains "content".
     *
     *   <p>
     *
     *         MEOS Functions:
     *             <li>contains_set_set</li>
     *             <li>contains_textset_text</li>
     *
     * @param other object to compare with
     * @return True if contains, False otherwise
     * @throws Exception
     */
    public boolean contains(Object other) throws Exception {
        if (other instanceof String){
            TextSet tset = new TextSet((String)other);
            return functions.contains_textset_text(this._inner,tset._inner);
        }
        else {
            return super.contains((Base)other);
        }
    }


    /** ------------------------- Transformations -------------------------------- */


    /**
     * Returns a new textset that is the result of appling uppercase to "this"
     *
     * <p>
     *         MEOS Functions:
     *             <li>textset_lower</li>
     *
     * @return A new {@link TextSet} instance
     */
    public TextSet lowercase(){
        return new TextSet(functions.textset_lower(this._inner));
    }

    /**
     * Returns a new textset that is the result of appling uppercase to "this"
     *
     * <p>
     *
     *         MEOS Functions:
     *             <li>textset_upper</li>
     *
     * @return A new {@link TextSet} instance
     */
    public TextSet uppercase(){
        return new TextSet(functions.textset_upper(this._inner));
    }



    /** ------------------------- Set Operations -------------------------------- */

    //TODO: intersection

    /**
     * Returns the difference of "this" and "other".
     *
     * <p>
     *
     *         MEOS Functions:
     *             <li>minus_textset_text</li>
     *             <li>minus_set_set</li>
     *
     * @param other A {@link TextSet} or {@link String} instance
     * @return A {@link TextSet} instance or "null" if the difference is empty.
     */
    public TextSet minus(Object other){
        if (other instanceof String){
            TextSet tmptxt = new TextSet((String) other);
            return new TextSet(functions.minus_textset_text(this._inner, tmptxt._inner));
        }

        else if (other instanceof TextSet){
            return new TextSet(functions.minus_set_set(this._inner,((TextSet) other)._inner));
        }

        else{
            return null;
            //return super.minus(other);
        }
    }

    /*
    public String subtract_from(Object other){
        functions.minus_text_textset(other)
    }

     */


    /**
     * Returns the union of "this" and "other".
     *
     *  <p>
     *
     *         MEOS Functions:
     *             <li>union_textset_text</li>
     *             <li>union_set_set</li>
     *
     * @param other A :class:`TextSet` or :class:`str` instance
     * @return A :class:`TextSet` instance.
     */
    public TextSet union(Object other){
        if (other instanceof String){
            TextSet tmptxt = new TextSet((String) other);
            return new TextSet(functions.union_textset_text(this._inner, tmptxt._inner));
        }

        else if (other instanceof TextSet){
            return new TextSet(functions.union_set_set(this._inner,((TextSet) other)._inner));
        }

        else{
            return null;
            //return super.minus(other);
        }
    }





}