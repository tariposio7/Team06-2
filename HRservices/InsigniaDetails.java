package com.tariposio.team06.HRservices;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TaRipoSio on 23/4/2560.
 */

public class InsigniaDetails {
    @SerializedName("ins_year")
    public String ins_year;

    @SerializedName("dc_name")
    public String dc_name;

    @SerializedName("ins_valumn")
    public String ins_valumn;

    @SerializedName("ins_book_part")
    public String ins_book_part;

    @SerializedName("ins_book_date")
    public String ins_book_date;

    @SerializedName("ins_book_page")
    public String ins_book_page;

    @SerializedName("ins_book_order")
    public String ins_book_order;
}
