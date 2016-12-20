package comsiteprojectcyborn.google.sites.findyournexthome.model;

/**
 * Created by msrabon on 12/14/16.
 */

public class RentalAds {
    String bannerText;
    int bedRoom;
    int bathRoom;
    int balcony;
    int livingRoom;
    int drawingRoom;
    int kitchen;
    int floorType;
    int floorLevel;
    String direction;
    boolean parking;
    boolean liftAvailability;
    boolean furnished;
    int size;
    int serviceCharge;
    int securityDeposit;
    int rent;
    String leaseTerm;
    String bannerImageLocation;
    String imageOneLocation;
    String imagetwoLocation;
    String ownerLink;

    /**
     *
     * @param bannerText
     * @param bedRoom
     * @param bathRoom
     * @param balcony
     * @param livingRoom
     * @param drawingRoom
     * @param kitchen
     * @param floorType
     * @param floorLevel
     * @param direction
     * @param parking
     * @param liftAvailability
     * @param furnished
     * @param size
     * @param serviceCharge
     * @param securityDeposit
     * @param rent
     * @param leaseTerm
     * @param bannerImageLocation
     * @param imageOneLocation
     * @param imagetwoLocation
     * @param ownerLink
     */
    public RentalAds(String bannerText, int bedRoom, int bathRoom, int balcony, int livingRoom,
                     int drawingRoom, int kitchen, int floorType, int floorLevel, String direction,
                     boolean parking, boolean liftAvailability, boolean furnished, int size,
                     int serviceCharge, int securityDeposit, int rent, String leaseTerm,
                     String bannerImageLocation, String imageOneLocation, String imagetwoLocation,
                     String ownerLink) {
        this.bannerText = bannerText;
        this.bedRoom = bedRoom;
        this.bathRoom = bathRoom;
        this.balcony = balcony;
        this.livingRoom = livingRoom;
        this.drawingRoom = drawingRoom;
        this.kitchen = kitchen;
        this.floorType = floorType;
        this.floorLevel = floorLevel;
        this.direction = direction;
        this.parking = parking;
        this.liftAvailability = liftAvailability;
        this.furnished = furnished;
        this.size = size;
        this.serviceCharge = serviceCharge;
        this.securityDeposit = securityDeposit;
        this.rent = rent;
        this.leaseTerm = leaseTerm;
        this.bannerImageLocation = bannerImageLocation;
        this.imageOneLocation = imageOneLocation;
        this.imagetwoLocation = imagetwoLocation;
        this.ownerLink = ownerLink;
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

    public int getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(int livingRoom) {
        this.livingRoom = livingRoom;
    }

    public int getDrawingRoom() {
        return drawingRoom;
    }

    public void setDrawingRoom(int drawingRoom) {
        this.drawingRoom = drawingRoom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getFloorType() {
        return floorType;
    }

    public void setFloorType(int floorType) {
        this.floorType = floorType;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
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

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(int securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(String leaseTerm) {
        this.leaseTerm = leaseTerm;
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
}
