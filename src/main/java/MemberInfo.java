import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberInfo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 民族
     */
    private String nationName;
    /**
     * 生日   19760422
     */
    private String birth;
    /**
     * 地址
     */
    private String address;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     *  办证机构
     */
    private String policeAddress;
    /**
     * 有效期开始
     */
    private String startTime;
    /**
     * 有效期结束
     */
    private String endTime;
    /**
     * 安全模块号
     */
    private String securityNo;

    public String getSecurityNo() {
        return securityNo;
    }

    public void setSecurityNo(String securityNo) {
        this.securityNo = securityNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPoliceAddress() {
        return policeAddress;
    }

    public void setPoliceAddress(String policeAddress) {
        this.policeAddress = policeAddress;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nationName='" + nationName + '\'' +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                ", idCard='" + idCard + '\'' +
                ", policeAddress='" + policeAddress + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String cmd = "C:\\Users\\zxd\\IdeaProjects\\IDCARD_READ\\ConsoleApplication1.exe";
        System.out.println("Execute command : " + cmd);
        Runtime runtime = Runtime.getRuntime();
        BufferedReader br=null;
        Process process = null;
        try {
            process = runtime.exec("cmd /c start " + cmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder build = new StringBuilder();
            while ((line = br.readLine()) != null) {
                System.err.println(line);
                build.append(line);
            }
            System.out.println (build.toString());
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
}
