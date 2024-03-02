package com.gafasmatch.visualstyle.data

import android.os.Parcel
import android.os.Parcelable

class Gafa(
    val id: Int,
    val nombre: String?,
    val descripcion: String?,
    val foto: String?,
    val optica: String?,
    var isFavorite: Boolean = false,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Gafa> {
        override fun createFromParcel(parcel: Parcel): Gafa {
            return Gafa(parcel)
        }

        override fun newArray(size: Int): Array<Gafa?> {
            return arrayOfNulls(size)
        }
    }
}