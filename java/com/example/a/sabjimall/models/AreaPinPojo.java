package com.example.a.sabjimall.models;

import java.util.ArrayList;

public class AreaPinPojo {
    String pinCode;
    String areaName;
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public AreaPinPojo(String areaName, String pinCode) {
        this.pinCode = pinCode;
        this.areaName = areaName;
    }

   public String toString()
    {
        return areaName+"("+pinCode+")";
    }

    public static ArrayList<AreaPinPojo> getAreaPin() {
        ArrayList<AreaPinPojo> areaPinList = new ArrayList<>();
        areaPinList.add(new AreaPinPojo("Pimpri", "412303"));
        areaPinList.add(new AreaPinPojo("Chinchwad", "411019"));
        areaPinList.add(new AreaPinPojo("Bijalinagar", "411018"));
        areaPinList.add(new AreaPinPojo("Nashik Phata", "411034"));
        areaPinList.add(new AreaPinPojo("Kasarwadi", "411034"));
        areaPinList.add(new AreaPinPojo("Nigdi", "411044"));
        areaPinList.add(new AreaPinPojo("Nigdi Pradhikaran", "411044"));
        areaPinList.add(new AreaPinPojo("Akurdi", "411035"));
        areaPinList.add(new AreaPinPojo("Tathawade", "411033"));
        areaPinList.add(new AreaPinPojo("Bhosari", "411039"));
        areaPinList.add(new AreaPinPojo("Bhosari", "411026"));
        areaPinList.add(new AreaPinPojo("Bhosari", "411014"));
        areaPinList.add(new AreaPinPojo("Talawade", "412114"));
        areaPinList.add(new AreaPinPojo("Hinjawadi", "411057"));
        areaPinList.add(new AreaPinPojo("Sambhajinagar", "411018"));
        areaPinList.add(new AreaPinPojo("Ajmera Colony", "411027"));
        areaPinList.add(new AreaPinPojo("Masulkar colony", "411007"));
        areaPinList.add(new AreaPinPojo("Sangvi", "411027"));
        areaPinList.add(new AreaPinPojo("Pimple Nilakh", "411027"));
        areaPinList.add(new AreaPinPojo("Aundh Camp", "411027"));
        areaPinList.add(new AreaPinPojo("Wakad", "411057"));
        areaPinList.add(new AreaPinPojo("Sant Tukaram Nagar", "411018"));
        areaPinList.add(new AreaPinPojo("Nehrunagar", "411018"));
        areaPinList.add(new AreaPinPojo("Mahesh Nagar", "411018"));
        areaPinList.add(new AreaPinPojo("Ganga Nagar", "411018"));
        areaPinList.add(new AreaPinPojo("Vallabh Nagar", "411018"));
        areaPinList.add(new AreaPinPojo("Pimple Gurav", "411027"));
        areaPinList.add(new AreaPinPojo("Pimple Gurav", "411061"));
        areaPinList.add(new AreaPinPojo("Kalewadi", "411017"));
        areaPinList.add(new AreaPinPojo("Thergaon", "411033"));
        areaPinList.add(new AreaPinPojo("Chikhali", "412114"));
        areaPinList.add(new AreaPinPojo("Rahatani", "411017"));
        areaPinList.add(new AreaPinPojo("Pimple Saudagar", "411027"));
        areaPinList.add(new AreaPinPojo("Punawale", "411033"));
        areaPinList.add(new AreaPinPojo("Moshi", "412105"));
        areaPinList.add(new AreaPinPojo("Ravet", "411018"));
        areaPinList.add(new AreaPinPojo("Dapodi", "411012"));
        areaPinList.add(new AreaPinPojo("Shahunagar", "411019"));
        areaPinList.add(new AreaPinPojo("Indryaninagar", "411044"));
        areaPinList.add(new AreaPinPojo("Rupeenagar", "411044"));
        areaPinList.add(new AreaPinPojo("Chakan", "410501"));
        areaPinList.add(new AreaPinPojo("Rajgurunagar", "410505"));
        return areaPinList;
    }
}