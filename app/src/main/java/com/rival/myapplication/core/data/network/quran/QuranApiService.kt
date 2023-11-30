package com.rival.myapplication.core.data.network.quran

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApiService {

    //get list nama surat Al-quran
    @GET("surah")
    fun getListSurah(): Call<SurahResponse>

    @GET("surah/{number}/editions/quran-uthmani,ar.alafasy,id.indonesian")
    fun getDetailSurah(
        @Path("number") numberSurah: Int
    ): Call<AyahResponse>
}