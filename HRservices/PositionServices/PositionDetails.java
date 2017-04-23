package com.tariposio.team06.HRservices.PositionServices;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TaRipoSio on 23/4/2560.
 */

public class PositionDetails {
    @SerializedName("kppos_date")
    public String kppos_date;

    @SerializedName("alp_name")
    public String alp_name;

    @SerializedName("pos_name")
    public String pos_name;

    @SerializedName("plv_name")
    public String plv_name;

    @SerializedName("kppos_pos_salary")
    public String kppos_pos_salary;

    @SerializedName("kppos_pos_reference")
    public String kppos_pos_reference;

    @SerializedName("kppos_file")
    public String kppos_file;

    @SerializedName("kppos_file_name")
    public String kppos_file_name;
}
