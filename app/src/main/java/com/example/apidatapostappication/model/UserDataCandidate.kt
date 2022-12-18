package com.example.apidatapostappication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class UserDataCandidate():Parcelable {
    @SerializedName("UserId")
    @Expose
    var userId: Int? = null

    @SerializedName("Email")
    @Expose
    var email: String? = null

    @SerializedName("FirstName")
    @Expose
    var firstName: String? = null

    @SerializedName("LastName")
    @Expose
    var lastName: String? = null

    @SerializedName("UserType")
    @Expose
    var userType: String? = null

    @SerializedName("NotificationToken")
    @Expose
    private var notificationToken: String? = null

    @SerializedName("ProfilePic")
    @Expose
    var profilePic: String? = null

    @SerializedName("ResumeName")
    @Expose
    private var resumeName: String? = null

    @SerializedName("Resume")
    @Expose
    var resume: String? = null

    @SerializedName("ResumeLink")
    @Expose
    var resumeLink: String? = null

    @SerializedName("AuthenicateToken")
    @Expose
    var authenicateToken: String? = null

    @SerializedName("Langauge")
    @Expose
    var langauge: String? = null

    constructor(parcel: Parcel) : this() {
        userId = parcel.readValue(Int::class.java.classLoader) as? Int
        email = parcel.readString()
        firstName = parcel.readString()
        lastName = parcel.readString()
        userType = parcel.readString()
        notificationToken = parcel.readString()
        profilePic = parcel.readString()
        profilePic = parcel.readString()
        resume = parcel.readString()
        resumeLink = parcel.readString()
        authenicateToken = parcel.readString()
        langauge = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeString(email)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(userType)
        parcel.writeString(notificationToken)
        parcel.writeString(profilePic)
        parcel.writeString(resumeName)
        parcel.writeString(resume)
        parcel.writeString(resumeLink)
        parcel.writeString(authenicateToken)
        parcel.writeString(langauge)
    }

    override fun describeContents(): Int {
        return 0
    }



    companion object CREATOR : Parcelable.Creator<UserDataCandidate> {
        override fun createFromParcel(parcel: Parcel): UserDataCandidate {
            return UserDataCandidate(parcel)
        }

        override fun newArray(size: Int): Array<UserDataCandidate?> {
            return arrayOfNulls(size)
        }
    }


}