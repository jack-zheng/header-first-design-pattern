package chapter11.coversample;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String, String> cds = new Hashtable<String, String>();

    public static void main (String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        cds.put("Buddha Bar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588614514102&di=f68b39967eeafef906f6015a379dc9ff&imgtype=0&src=http%3A%2F%2Fimgboys1.yohobuy.com%2Fcmsimg01%2F2018%2F07%2F10%2F01%2F23%2F01595e184cd06c6f0544fa84444970b77e.jpeg");
        cds.put("Ima","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588614514101&di=20ed9c8d5b5929026bb90868225f0272&imgtype=0&src=http%3A%2F%2Fwww.jiefuku.com%2Fuploads%2Fallimg%2F171229%2F5-1G229105349-50.jpg");
        cds.put("Karma","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588614514100&di=4d1d77f84b724525022ee58750d12618&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn10%2F27%2Fw953h674%2F20181018%2F16b4-hmhhnqs9134596.jpg");
        cds.put("MCMXC A.D.","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588614514100&di=8fc9698f5658025c0c615759f793d427&imgtype=0&src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F10583030926%2F1000.jpg");
        cds.put("Northern Exposure","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588614514100&di=06f48bbe35cb98fdf4ac6433a1f6d640&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2Fwlg5GCsid0Cs6383fx0OJIJ226Wb9dx9IIAosaWJLZd3q1541223114965compressflag.jpg");
        cds.put("Selected Ambient Works, Vol. 2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588614514098&di=32d69e268aaf3df937581307c3282e03&imgtype=0&src=http%3A%2F%2Ftva1.sinaimg.cn%2Fmw690%2F006HyO5Kly1fz44fc0y54j30j60srjto.jpg");

        URL initialURL = new URL((String)cds.get("Selected Ambient Works, Vol. 2"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for (Enumeration<String> e = cds.keys(); e.hasMoreElements();) {
            String name = (String)e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(event -> {
                imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
                frame.repaint();
            });
        }

        // set up frame and menus

        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);

    }

    URL getCDUrl(String name) {
        try {
            return new URL((String)cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
