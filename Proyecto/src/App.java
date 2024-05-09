import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class App extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblDirectionRobot;
	private JLabel lblObstacul;
	private JLabel lblBatery;
	private Rectangle[] obtacles;

	Canvas canvas;

	private int yRobot = 33;
	private int xRobot = 12;
	private int xBox = 120;
	private int yBox = 95;
	private int batery = 1750;

	// private int x

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setTitle("ROBOT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 450);
		contentPane = new JPanel();
		contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();

		contentPane.addKeyListener(this);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 333, 525, 67);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("DIRECCION DEL ROBOT:");
		lblNewLabel_1.setBounds(10, 11, 148, 14);
		panel.add(lblNewLabel_1);

		lblDirectionRobot = new JLabel("");
		lblDirectionRobot.setBounds(151, 11, 125, 14);
		panel.add(lblDirectionRobot);

		JLabel lblNewLabel_1_1 = new JLabel("OBSTACULO:");
		lblNewLabel_1_1.setBounds(10, 42, 80, 14);
		panel.add(lblNewLabel_1_1);

		lblObstacul = new JLabel("");
		lblObstacul.setBounds(94, 42, 125, 14);
		panel.add(lblObstacul);

		JLabel lblNewLabel_1_1_1 = new JLabel("BATERIA");
		lblNewLabel_1_1_1.setBounds(305, 11, 53, 14);
		panel.add(lblNewLabel_1_1_1);

		lblBatery = new JLabel("");
		lblBatery.setBounds(365, 11, 118, 14);
		panel.add(lblBatery);

		canvas = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.black);
				g.fillRect(xRobot, yRobot, 30, 30);

				g.setColor(Color.RED);
				g.fillRect(xBox, yBox, 20, 20);

				g.setColor(Color.green);
				g.fillRect(475, 255, 30, 30);

				g.setColor(Color.black);
				g.drawRect(10, 10, 500, 285);
				g.fillRect(10, 11, 500, 15);
				g.fillRect(10, 70, 40, 15);
				g.fillRect(645, 10, 90, 15);
				g.fillRect(720, 10, 15, 90);
				g.fillRect(10, 125, 65, 15);
				g.fillRect(118, 125, 15, 65);
				g.fillRect(200, 70, 30, 15);
				g.fillRect(170, 125, 60, 15);
				g.fillRect(360, 70, 45, 15);
				g.fillRect(310, 70, 15, 70);
				g.fillRect(272, 175, 83, 15);
				g.fillRect(170, 175, 115, 15);
				g.fillRect(90, 70, 70, 15);
				g.fillRect(60, 175, 15, 70);
				g.fillRect(10, 70, 15, 220);
				g.fillRect(10, 280, 500, 15);
				g.fillRect(500, 10, 15, 286);
				g.fillRect(119, 225, 180, 15);
				g.fillRect(360, 70, 15, 65);
				g.fillRect(360, 120, 35, 15);
				g.fillRect(392, 120, 15, 40);
				g.fillRect(392, 200, 60, 15);
				g.fillRect(272, 125, 50, 15);
				g.fillRect(272, 70, 40, 15);
				g.fillRect(340, 190, 15, 50);
				g.fillRect(450, 70, 15, 170);
			}

		};

		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("x:" + x);
				System.out.println("y: " + y);
			}
		});

		canvas.setBackground(Color.LIGHT_GRAY);

		canvas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				contentPane.requestFocusInWindow();
			}
		});
		canvas.setForeground(new Color(255, 255, 255));
		canvas.setBounds(10, 10, 525, 303);
		contentPane.add(canvas);

		obtacles = new Rectangle[26];
		obtacles[0] = new Rectangle(10, 11, 500, 15);
		obtacles[1] = new Rectangle(10, 70, 40, 15);
		obtacles[2] = new Rectangle(645, 10, 90, 15);
		obtacles[3] = new Rectangle(720, 10, 15, 90);
		obtacles[4] = new Rectangle(10, 125, 65, 15);
		obtacles[5] = new Rectangle(118, 125, 15, 65);
		obtacles[6] = new Rectangle(200, 70, 30, 15);
		obtacles[7] = new Rectangle(170, 125, 60, 15);
		obtacles[8] = new Rectangle(360, 70, 45, 15);
		obtacles[9] = new Rectangle(310, 70, 15, 70);
		obtacles[10] = new Rectangle(272, 175, 83, 15);
		obtacles[11] = new Rectangle(170, 175, 115, 15);
		obtacles[12] = new Rectangle(90, 70, 70, 15);
		obtacles[13] = new Rectangle(60, 175, 15, 70);
		obtacles[14] = new Rectangle(10, 70, 15, 220);
		obtacles[15] = new Rectangle(10, 280, 500, 15);
		obtacles[16] = new Rectangle(500, 10, 15, 286);
		obtacles[17] = new Rectangle(119, 225, 180, 15);
		obtacles[18] = new Rectangle(360, 70, 15, 65);
		obtacles[19] = new Rectangle(360, 120, 35, 15);
		obtacles[20] = new Rectangle(392, 120, 15, 40);
		obtacles[21] = new Rectangle(392, 200, 60, 15);
		obtacles[22] = new Rectangle(272, 125, 50, 15);
		obtacles[23] = new Rectangle(272, 70, 40, 15);
		obtacles[24] = new Rectangle(340, 190, 15, 50);
		obtacles[25] = new Rectangle(450, 70, 15, 170);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyPressed(KeyEvent e) {

		if (batery >= 0) {		
			// TODO Auto-generated method stub
			int newX = xRobot;
			int newY = yRobot;

			int newXBox = xBox;
			int newYBox = yBox;

			boolean collisionBox = false;
			boolean collision = false;

			lblBatery.setText("" + batery + "%");

			Graphics g = canvas.getGraphics();

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("Se preciono la tecla hacia abajo");

				lblDirectionRobot.setText("ABAJO");
				g.setColor(Color.black);
				g.clearRect(xRobot, yRobot, 30, 30);
				g.clearRect(xBox, yBox, 20, 20);

				if (yRobot < 300) {
					newY += 4;
				}

				if (xRobot >= xBox - 10 && xRobot <= xBox && (yBox - 30 <= yRobot && yRobot <= yBox)) {
					newYBox += 4;
					System.out.println("Entre");
				}

				Rectangle robotBounds = new Rectangle(newX, newY, 30, 30);
				Rectangle boxBounds = new Rectangle(xBox, yBox + 5, 20, 20);

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(robotBounds)) {
						collision = true;
						break;
					}
				}

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(boxBounds)) {
						collisionBox = true;
						break;
					}
				}

				System.out.println(collision);

				if (!collision) {
					xRobot = newX;
					yRobot = newY;
					batery -= 5;
					lblObstacul.setText("False");
				} else {
					lblObstacul.setText("True");
				}

				if (!collisionBox) {
					yBox = newYBox;
					xBox = newXBox;
				}

				System.out.println("Y: " + yRobot + " X:" + xRobot);
				System.out.println("Y: " + yBox + "X: " + xBox);

				g.setColor(Color.black);
				g.fillRect(xRobot, yRobot, 30, 30);

				g.setColor(Color.RED);
				g.fillRect(xBox, yBox, 20, 20);
			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("Se preciono la tecla hacia arriba");
				lblDirectionRobot.setText("ARRIBA");
				g.setColor(Color.black);
				g.clearRect(xRobot, yRobot, 30, 30);
				g.clearRect(xBox, yBox, 20, 20);

				if (yRobot > 13) {
					newY -= 4;
				}

				if (xRobot >= xBox - 35 && xRobot <= xBox && (yBox <= yRobot && yRobot <= yBox + 20)) {
					newYBox -= 4;
				}

				Rectangle robotBounds = new Rectangle(newX, newY, 30, 30);
				Rectangle boxBounds = new Rectangle(xBox, yBox - 5, 20, 20);

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(robotBounds)) {
						collision = true;
						break;
					}
				}

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(boxBounds)) {
						collisionBox = true;
						break;
					}
				}

				System.out.println(collision);

				if (!collision) {
					xRobot = newX;
					yRobot = newY;
					batery -= 5;
					lblObstacul.setText("False");
				} else {
					lblObstacul.setText("True");
				}

				if (!collisionBox) {
					yBox = newYBox;
					xBox = newXBox;
				}

				xBox = newXBox;

				System.out.println("Y: " + yRobot + " X:" + xRobot);
				System.out.println("Y: " + yBox + "X: " + xBox);

				g.setColor(Color.black);
				g.fillRect(xRobot, yRobot, 30, 30);

				g.setColor(Color.RED);
				g.fillRect(xBox, yBox, 20, 20);
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("Se preciono la tecla hacia derecha");
				lblDirectionRobot.setText("DERECHA");

				g.setColor(Color.black);
				g.clearRect(xRobot, yRobot, 30, 30);
				g.clearRect(xBox, yBox, 20, 20);

				System.out.println(collisionBox);

				if (xRobot < 580) {
					newX += 4;
				}

				if (xRobot <= xBox - 28 && xRobot >= xBox - 28 && (yBox - 20 <= yRobot && yRobot <= yBox + 20)) {
					newXBox += 4;
					System.out.println("Entre");
				}

				Rectangle robotBounds = new Rectangle(newX, newY, 30, 30);
				Rectangle boxBounds = new Rectangle(xBox + 5, yBox, 20, 20);

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(robotBounds)) {
						collision = true;
						break;
					}
				}

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(boxBounds)) {
						collisionBox = true;
						break;
					}
				}

				if (!collision) {
					xRobot = newX;
					yRobot = newY;
					batery -= 5;
					lblObstacul.setText("False");
				} else {
					lblObstacul.setText("True");
				}

				if (!collisionBox) {
					xBox = newXBox;
					yBox = newYBox;
				}

				System.out.println("Y: " + yRobot + " X:" + xRobot);
				System.out.println("Y: " + yBox + "X: " + xBox);

				g.setColor(Color.black);
				g.fillRect(xRobot, yRobot, 30, 30);

				g.setColor(Color.RED);
				g.fillRect(xBox, yBox, 20, 20);

				System.out.println(collisionBox);
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("Se preciono la tecla hacia izquierda");
				lblDirectionRobot.setText("IZQUIERDA");
				g.setColor(Color.black);
				g.clearRect(xRobot, yRobot, 30, 30);
				g.clearRect(xBox, yBox, 20, 20);

				if (xRobot > 12) {
					newX -= 4;
				}

				if (xRobot >= xBox + 20 && xRobot <= xBox + 20 && (yBox - 20 <= yRobot && yRobot <= yBox + 20)) {
					newXBox -= 4;
					System.out.println("Entre");
				}
				Rectangle robotBounds = new Rectangle(newX, newY, 30, 30);
				Rectangle boxBounds = new Rectangle(xBox - 5, yBox, 20, 20);

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(robotBounds)) {
						collision = true;
						break;
					}
				}

				for (Rectangle obtacles : obtacles) {
					if (obtacles.intersects(boxBounds)) {
						collisionBox = true;
						break;
					}
				}

				System.out.println(collision);

				if (!collision) {
					xRobot = newX;
					yRobot = newY;
					batery -= 5;
					lblObstacul.setText("False");
				} else {
					lblObstacul.setText("True");
				}

				if (!collisionBox) {
					xBox = newXBox;
					yBox = newYBox;
				}

				System.out.println("Y: " + yRobot + " X:" + xRobot);
				System.out.println("Y: " + yBox + "X: " + xBox);

				g.setColor(Color.black);
				g.fillRect(xRobot, yRobot, 30, 30);

				g.setColor(Color.RED);
				g.fillRect(xBox, yBox, 20, 20);
			}
			System.out.println(xRobot);
			System.out.println(yRobot);
			// verificacion de contacto
		}
		else{
			JOptionPane.showMessageDialog(null, "Se Agoto la Bateria", "GAME OVER", JOptionPane.ERROR_MESSAGE);
			batery = 1750;
			yRobot = 33;
			xRobot = 12;
			xBox = 120;
			yBox = 95;

			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}