package br.com.joaomourato.fragments;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModel implements Parcelable {
    private String brand;
    private String model;
    private String details;
    private int img;

    protected DataModel(Parcel in) {
        brand = in.readString();
        model = in.readString();
        details = in.readString();
        img = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(model);
        dest.writeString(details);
        dest.writeInt(img);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getDetails() {
        return details;
    }

    public int getImg() {
        return img;
    }

    public static class DataModelBuilder{
        private  String brand;
        private  String model;
        private  String details;
        private  int img;

        //construtor privado para não ser estancido por aqui
        private DataModelBuilder(){}

        public static DataModelBuilder builder(){
            return new DataModelBuilder();
        }

        public DataModelBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public DataModelBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public DataModelBuilder setDetails(String details) {
            this.details = details;
            return this;
        }

        public DataModelBuilder setImg(int img) {
            this.img = img;
            return this;
        }

        public DataModel build(){
            return new DataModel(this);
        }
    }

    private DataModel(DataModelBuilder builder) {
        brand = builder.brand;
        model = builder.model;
        details = builder.details;
        img = builder.img;
    }
}
