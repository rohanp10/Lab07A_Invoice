import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.ArrayList;

public class InvoiceFrame extends JFrame {

    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton generateInvoice;
    JButton quit;

    ArrayList<String> lines = new ArrayList<String>();

    int fortuneIndex = -1;

    Random rnd = new Random();


    public InvoiceFrame()
    {
        mainPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());

        createTopPnl();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePnl();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPnl();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

    }

    private void createTopPnl()
    {
        topPnl = new JPanel();
        titleLbl = new JLabel("Invoice", JLabel.CENTER);

        titleLbl.setFont(new Font("Roboto", Font.PLAIN, 36));

        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.setBackground(new Color(198,226,255));

        topPnl.add(titleLbl);
    }

    private void createMiddlePnl()
    {
        middlePnl = new JPanel();
        displayTA = new JTextArea(12, 40);

        displayTA.setFont(new Font("Verdana", Font.PLAIN, 14));

        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);

        middlePnl.setBackground(new Color(198,226,255));

    }

    private void createBottomPnl()
    {
        lines.add("Toaster              3       $29.95      $89.95");
        lines.add("Hair Dryer          1       $24.95      $84.95");
        lines.add("Car Vacuum       2       $19.99      $39.98");

        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));

        double amountDue = 154.78;

        generateInvoice = new JButton("Generate Invoice");
        generateInvoice.addActionListener((ActionEvent ae) ->
        {
            displayTA.append("INVOICE\n");

            displayTA.append("\n");

            displayTA.append("Sam's Small Appliances\n");
            displayTA.append("100 Main Street\n");
            displayTA.append("Anytown, CA, 98765\n");

            displayTA.append("-----------------------------------------------\n");
            displayTA.append("Item              Qty         Price       Total\n");

            for (String line: lines) {
                displayTA.append(line + "\n");
            }

            displayTA.append("-----------------------------------------------\n");

            displayTA.append("Amount Due: $" + amountDue);
        });

        quit = new JButton("Quit");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));

        generateInvoice.setPreferredSize(new Dimension(40, 40));
        quit.setPreferredSize(new Dimension(40, 40));

        generateInvoice.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        quit.setFont(new Font("Sans Serif", Font.PLAIN, 15));

        bottomPnl.add(generateInvoice);
        bottomPnl.add(quit);

        bottomPnl.setBackground(new Color(198,226,255));

    }
}
