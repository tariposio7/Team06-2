package com.tariposio.team06.HRservices;

import com.tariposio.team06.HRservices.ProfileServices.ProfileServices;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by TaRipoSio on 23/4/2560.
 */

public interface HRservices {
    @POST("index.php/hr/official/get_profile_json/950")
    Call<ProfileServices> getProfiledata();


}
