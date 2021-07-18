package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class stores the requirements of the client. All the requirements required related to media are stored by using
// this class
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Media_Requirements
{
    private int photography, videography;
    private int album_printing, drone, crane;

    public Media_Requirements() {
        photography = videography = album_printing = drone = crane = 0;
    }

    public Media_Requirements(int photography, int videography, int album_printing, int drone, int crane) {
        this.photography = photography;
        this.videography = videography;
        this.album_printing = album_printing;
        this.drone = drone;
        this.crane = crane;
    }

    public int getPhotography() {
        return photography;
    }
    public void setPhotography(int photography) {
        this.photography = photography;
    }

    public int getVideography() {
        return videography;
    }
    public void setVideography(int videography) {
        this.videography = videography;
    }

    public int getAlbum_printing() {
        return album_printing;
    }
    public void setAlbum_printing(int album_printing) {
        this.album_printing = album_printing;
    }

    public int getDrone() {
        return drone;
    }
    public void setDrone(int drone) {
        this.drone = drone;
    }

    public int getCrane() {
        return crane;
    }
    public void setCrane(int crane) {
        this.crane = crane;
    }

    public void display()                       //Display the details of the media requirements
    {
        String str;

        System.out.print("Videography: ");
        str = (videography == 1) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Photography: ");
        str = (photography== 1) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Album Printing: ");
        str = (album_printing == 1) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Drone: ");
        str = (drone == 1) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Crane: ");
        str = (crane == 1) ? "Yes" : "No";
        System.out.println(str);
    }

    public Media_Requirements getMedia(String media_id) {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        return obj.getMediaRequirement(media_id);
    }

    public String addMediaRequirements() {
        Media_RequirementsDB obj = new Media_RequirementsDB();
        String media_id = obj.addMediaRequirement(this);
        return media_id;
    }
}