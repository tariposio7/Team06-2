package com.tariposio.team06.HRservices;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by TaRipoSio on 23/4/2560.
 */

public interface HRservices {

    @POST("index.php/hr/official/get_profile_json/950")
    Call<ProfileServices> getProfileData();

    @POST("index.php/hr/official/get_resume_json/950")
    Call<ResumeServices> getResumeData();

    @POST("index.php/hr/official/get_position_json")
    Call<PositionServices> getPositionData();

    @POST("index.php/hr/official/get_insignia_json/950")
    Call<InsigniaServices> getInsigniaData();


}
