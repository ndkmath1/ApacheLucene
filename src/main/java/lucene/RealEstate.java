package lucene;

/**
 * Created by khanh on 27/03/2018.
 */
public class RealEstate {

    private String district;
    private String province;
    private String contactAddress;
    private String title;
    private String categoryName;
    private String projectName;
    private String projectInvestor;
    private String projectSize;
    private String address;
    private String description;

    public RealEstate(String district, String province, String contactAddress, String title, String categoryName, String projectName, String projectInvestor, String projectSize, String address, String description) {
        this.district = district;
        this.province = province;
        this.contactAddress = contactAddress;
        this.title = title;
        this.categoryName = categoryName;
        this.projectName = projectName;
        this.projectInvestor = projectInvestor;
        this.projectSize = projectSize;
        this.address = address;
        this.description = description;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectInvestor() {
        return projectInvestor;
    }

    public void setProjectInvestor(String projectInvestor) {
        this.projectInvestor = projectInvestor;
    }

    public String getProjectSize() {
        return projectSize;
    }

    public void setProjectSize(String projectSize) {
        this.projectSize = projectSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
