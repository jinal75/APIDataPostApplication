package com.example.apidatapostappication.utils

import android.os.Parcel
import android.os.Parcelable
import com.example.apidatapostappication.model.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ApiResponse() :Parcelable {
    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("UserData")
    @Expose
     var userData: UserDataCandidate? = null

    @SerializedName("SkillDetails")
    @Expose
     var skillDetails: List<SkillDetail>? = null

    @SerializedName("ExperienceDetails")
    @Expose
     var experienceDetails: List<ExperienceDetail>? = null

    @SerializedName("Degree")
    @Expose
     var degree: List<Degree>? = null

    @SerializedName("DegreeList")
    @Expose
     var degreeList: List<DegreeDetails>? = null
    @SerializedName("SkillList")
    @Expose
     var skillList:List<SkillDetails>?=null

    constructor(parcel: Parcel) : this() {
        status = parcel.readValue(Int::class.java.classLoader) as? Int
        message = parcel.readString()
        userData = parcel.readParcelable(UserDataCandidate::class.java.classLoader)
        skillDetails = parcel.createTypedArrayList(SkillDetail)
        experienceDetails = parcel.createTypedArrayList(ExperienceDetail)
        degree = parcel.createTypedArrayList(Degree)
        degreeList = parcel.createTypedArrayList(DegreeDetails)
        skillList = parcel.createTypedArrayList(SkillDetails)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(status)
        parcel.writeString(message)
        parcel.writeParcelable(userData, flags)
        parcel.writeTypedList(skillDetails)
        parcel.writeTypedList(experienceDetails)
        parcel.writeTypedList(degree)
        parcel.writeTypedList(degreeList)
        parcel.writeTypedList(skillList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiResponse> {
        override fun createFromParcel(parcel: Parcel): ApiResponse {
            return ApiResponse(parcel)
        }

        override fun newArray(size: Int): Array<ApiResponse?> {
            return arrayOfNulls(size)
        }
    }


}