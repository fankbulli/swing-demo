import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class EventDemo extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 8162801603108721756L;

    static JPanel contentPane;
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
    static JTextField textField4;
    static JTextField textField5;
    static JTextField textField6;
    static JTextField textField7;
    static JTextField textField8;
    static JTextField textField9;
    static JTextField textField10;
    static JTextField textField11;
    JButton jButton;


    static JLabel jLabel;
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// 设置程序外观的风格
            Font f = new Font("宋体",Font.PLAIN,12);
            String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
                    "JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
                    "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                    "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                    "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                    "PasswordField","TextField", "Table", "Label", "Viewport",
                    "RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
            };
            for (String item : names) {
                UIManager.put(item+ ".font",f);
            }
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        EventDemo frame = new EventDemo();// 设置窗体
        frame.setVisible(true);// 设置可见
    }


    public EventDemo(){
        setTitle("身份证阅读器桌面应用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,200,500, 600);
        contentPane = new JPanel();// 创建全局内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置边框大小
        contentPane.setLayout (null);
        setContentPane(contentPane);// 应用全局内容面板
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/deepexi.png"));
        setIconImage(image);
        /**
         * 服务器地址
         */
        // 创建 JLabel
        JLabel label = new JLabel("服务器地址"+":");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        label.setBounds(20,20,80,25);
        contentPane.add(label);
        /*
         * 创建文本域用于用户输入
         */
        textField1=new JTextField ();
        textField1.setBounds(100,20,350,25);
        contentPane.add(textField1);
        /**
         * 提示
         */
        JLabel labelMsg=new JLabel ("以下是身份证信息");
        labelMsg.setBounds (210,100,120,25);
        contentPane.add (labelMsg);

        /**
         * 图片
         */
        JLabel label1 = new JLabel("照片：");
        label1.setBounds(300,140,80,25);
        contentPane.add(label1);
        /**
         * 信息
         */
        JLabel label2 = new JLabel("姓名:");
        label2.setBounds(20,140,80,25);
        contentPane.add(label2);
        textField2 = new JTextField(20);
        textField2.setBounds(100,140,165,25);
        contentPane.add(textField2);

        JLabel label3 = new JLabel("性别:");
        label3.setBounds(20,180,80,25);
        contentPane.add(label3);
        textField3 = new JTextField(20);
        textField3.setBounds(100,180,165,25);
        contentPane.add(textField3);

        JLabel label4 = new JLabel("民族:");
        label4.setBounds(20,220,80,25);
        contentPane.add(label4);
        textField4 = new JTextField(20);
        textField4.setBounds(100,220,165,25);
        contentPane.add(textField4);

        JLabel label5 = new JLabel("生日:");
        label5.setBounds(20,260,80,25);
        contentPane.add(label5);
        textField5 = new JTextField(20);
        textField5.setBounds(100,260,165,25);
        contentPane.add(textField5);

        JLabel label6 = new JLabel("地址:");
        label6.setBounds(20,300,80,25);
        contentPane.add(label6);
        textField6 = new JTextField(20);
        textField6.setBounds(100,300,350,25);
        contentPane.add(textField6);

        JLabel label7 = new JLabel("身份证:");
        label7.setBounds(20,340,80,25);
        contentPane.add(label7);
        textField7 = new JTextField(20);
        textField7.setBounds(100,340,165,25);
        contentPane.add(textField7);

        JLabel label8 = new JLabel("签证公安局:");
        label8.setBounds(20,380,80,25);
        contentPane.add(label8);
        textField8 = new JTextField(20);
        textField8.setBounds(100,380,350,25);
        contentPane.add(textField8);

        JLabel label9 = new JLabel("有效期:");
        label9.setBounds(20,420,80,25);
        contentPane.add(label9);
        textField9 = new JTextField(20);
        textField9.setBounds(100,420,165,25);
        contentPane.add(textField9);

        JLabel label10 = new JLabel("安全模块号:");
        label10.setBounds(20,460,80,25);
        contentPane.add(label10);
        textField10 = new JTextField(20);
        textField10.setBounds(100,460,350,25);
        contentPane.add(textField10);

        JLabel label11 = new JLabel("返回信息:");
        label11.setBounds(20,500,80,25);
        contentPane.add(label11);
        textField11 = new JTextField(20);
        textField11.setBounds(100,500,350,25);
        contentPane.add(textField11);


        jLabel=new JLabel ();
        jLabel.setBounds(340,140,102,126);
        contentPane.add(jLabel);
        // 创建登录按钮
        JButton loginButton = new JButton("身份证识别按钮");
        loginButton.setBounds(150, 60, 200, 25);
        contentPane.add(loginButton);

        //按钮触发事件
        loginButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event) {

                /**
                 * 读卡
                 */
                Properties prop = System.getProperties();
                String name=prop.getProperty ("user.name");
                String path =prop.getProperty ("user.dir");
                String cmd=path+"\\ConsoleApplication1.exe";      //exe程序地址
                System.out.println("Execute command : " + cmd);
                Runtime runtime = Runtime.getRuntime();
                BufferedReader br1=null;
                Process process = null;
                StringBuilder build = new StringBuilder();
                try {
                    process = runtime.exec("cmd /c start " + cmd);
                    br1= new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                    String line = null;

                    while ((line = br1.readLine()) != null) {
                        System.err.println(line);
                        build.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                System.out.println (build.toString());
                    textField11.setText ("读卡成功！");
                    /**
                     * 读取生成文件
                     */
                    String source="C:\\Users\\"+name+"\\AppData\\Local\\Temp\\chinaidcard\\";
                    String url=source+"wz.txt";
                    File file=new File (url);
                    List<String> lines=new ArrayList ();
                    InputStreamReader ir=null;
                    BufferedReader br=null;
                    if(file.exists ()&&file.isFile ()){
                        try {
                            ir=new InputStreamReader (new FileInputStream (file),"GBK");
                            br=new BufferedReader (ir);
                            String line=null;
                            while (null!=(line=br.readLine ())){
                                lines.add (line);
                            }
                            ir.close ();
                            br.close ();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace ();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }

                    /**
                     * 设置显示
                     */
                    MemberInfo memberInfo=new MemberInfo ();
                    textField2.setText (lines.get (0));
                    memberInfo.setName (lines.get (0));
                    textField3.setText (lines.get (1));
                    memberInfo.setSex (lines.get (1));
                    textField4.setText (lines.get (2));
                    memberInfo.setNationName (lines.get (2));
                    textField5.setText (lines.get (3));
                    memberInfo.setBirth (lines.get (3));
                    textField6.setText (lines.get (4));
                    memberInfo.setAddress (lines.get (4));
                    textField7.setText (lines.get (5));
                    memberInfo.setIdCard (lines.get (5));
                    textField8.setText (lines.get (6));
                    memberInfo.setIdCard (lines.get (6));
                    textField9.setText (lines.get (7));
                    String[] dates=lines.get (7).split ("-");
                    memberInfo.setStartTime (dates[0]);
                    memberInfo.setEndTime (dates[1]);
                    textField10.setText (lines.get (8));
                    memberInfo.setSecurityNo (lines.get (8));


                    /**
                     *  设置图片
                     */
                    String pat=source+"zp.bmp";
                    String dest=source+"ai.png";
                    try {
                        File f = new File(pat);
                        f.canRead();
                        f.canWrite();
                        BufferedImage src = ImageIO.read(f);
                        ImageIO.write(src, "PNG", new File(dest));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ImageIcon  icon=new ImageIcon (dest);
                    Image image=icon.getImage ();
                    image=image.getScaledInstance (102,126,Image.SCALE_DEFAULT);
                    icon.setImage (image);
                    jLabel.setIcon (icon);
                    contentPane.add(jLabel);
                    /**
                     * todo 发送
                     */
                    String ipPath=textField1.getText ();
                    String result1=null;
                    textField11.setText ("读卡成功！"+result1);


            }

        });


    }

}
//http://127.0.0.1:8083/tongFangWeiShi/idCard/send
