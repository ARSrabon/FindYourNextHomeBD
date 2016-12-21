package comsiteprojectcyborn.google.sites.findyournexthome.model;

/**
 * Created by msrabon on 12/14/16.
 */

public class RentalAds {

    int bedRoom;
    int bathRoom;
    int balcony;
    boolean parking;
    boolean liftAvailability;
    String bannerText;
    String floorDeatils;
    String direction;
    String rentDeatils;
    String bannerImageLocation;
    String imageOneLocation;
    String imagetwoLocation;
    String ownerLink;
    String availableDate;

    public RentalAds() {
    }

    public RentalAds(int bedRoom, int bathRoom, int balcony, boolean parking, boolean liftAvailability,
                     String bannerText, String floorDeatils, String direction, String rentDeatils,
                     String bannerImageLocation, String imageOneLocation, String imagetwoLocation,
                     String ownerLink, String availableDate) {

        this.bedRoom = bedRoom;
        this.bathRoom = bathRoom;
        this.balcony = balcony;
        this.parking = parking;
        this.liftAvailability = liftAvailability;
        this.bannerText = bannerText;
        this.floorDeatils = floorDeatils;
        this.direction = direction;
        this.rentDeatils = rentDeatils;
        this.bannerImageLocation = bannerImageLocation;
        this.imageOneLocation = imageOneLocation;
        this.imagetwoLocation = imagetwoLocation;
        this.ownerLink = ownerLink;
        this.availableDate = availableDate;
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }

    public int getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(int bedRoom) {
        this.bedRoom = bedRoom;
    }

    public int getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(int bathRoom) {
        this.bathRoom = bathRoom;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public String getFloorDeatils() {
        return floorDeatils;
    }

    public void setFloorDeatils(String floorDeatils) {
        this.floorDeatils = floorDeatils;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isLiftAvailability() {
        return liftAvailability;
    }

    public void setLiftAvailability(boolean liftAvailability) {
        this.liftAvailability = liftAvailability;
    }

    public String getRentDeatils() {
        return rentDeatils;
    }

    public void setRentDeatils(String rentDeatils) {
        this.rentDeatils = rentDeatils;
    }

    public String getBannerImageLocation() {
        return bannerImageLocation;
    }

    public void setBannerImageLocation(String bannerImageLocation) {
        this.bannerImageLocation = bannerImageLocation;
    }

    public String getImageOneLocation() {
        return imageOneLocation;
    }

    public void setImageOneLocation(String imageOneLocation) {
        this.imageOneLocation = imageOneLocation;
    }

    public String getImagetwoLocation() {
        return imagetwoLocation;
    }

    public void setImagetwoLocation(String imagetwoLocation) {
        this.imagetwoLocation = imagetwoLocation;
    }

    public String getOwnerLink() {
        return ownerLink;
    }

    public void setOwnerLink(String ownerLink) {
        this.ownerLink = ownerLink;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }
}
