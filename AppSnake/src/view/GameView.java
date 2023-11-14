package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;

public class GameView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ArrayList<Point> snake = new ArrayList<>();
	private int direction = KeyEvent.VK_DOWN;
	private Point food;
	private boolean isGameOver = false;
	private int cellSize = 10;

	public GameView() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP
						|| key == KeyEvent.VK_DOWN) && Math.abs(key - direction) != 2) {
					direction = key;
				}
				if(key == KeyEvent.VK_ENTER) {
					if (isGameOver) {
			            isGameOver = false;
			            initializeGame();
			        }
				}
			}
		});
		setBorder(null);
		setBackground(new Color(183, 184, 154));
		setPreferredSize(new Dimension(19 * cellSize, 26 * cellSize));
		setFocusable(true);
		initializeGame();
		Timer timer = new Timer(200, this);
		timer.start();
	}

	private void initializeGame() {
		snake.clear();
		snake.add(new Point(5, 5));
		generateFood();
	}

	private void generateFood() {
		Random random = new Random();
		int x, y;
		do {
			x = random.nextInt(10);
			y = random.nextInt(9);
		} while (snake.contains(new Point(x, y)));
		food = new Point(x, y);
	}

	private void move() {
		Point head = snake.get(0);
		Point newHead = null;

		if (direction == KeyEvent.VK_UP) {
			newHead = new Point(head.x, head.y - 1);
		} else if (direction == KeyEvent.VK_DOWN) {
			newHead = new Point(head.x, head.y + 1);
		} else if (direction == KeyEvent.VK_LEFT) {
			newHead = new Point(head.x - 1, head.y);
		} else if (direction == KeyEvent.VK_RIGHT) {
			newHead = new Point(head.x + 1, head.y);
		}
		
		if (newHead != null) {
			snake.add(0, newHead);

			if (newHead.equals(food)) {
				generateFood();
			} else {
				snake.remove(snake.size() - 1);
			}

			if (checkCollision(newHead)) {
				isGameOver = true;
			}
		}
	}

	private boolean checkCollision(Point head) {
		return head.x < 0 || head.x >= 19 || head.y < 0 || head.y >= 26
				|| snake.indexOf(head) != snake.lastIndexOf(head);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (isGameOver) {
			g.setColor(new Color(70, 70, 70));
			g.setFont(new Font("Cascadia Code", Font.BOLD, 24));
			String gameOverText = "Game Over!";
			FontMetrics fm = g.getFontMetrics();
			int textWidth = fm.stringWidth(gameOverText);
			int x = (getWidth() - textWidth) / 2 + 1;
			int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent() - 12;
			g.drawString(gameOverText, x, y);
		} else {
			g.setColor(new Color(70, 70, 70));
			for (Point p : snake) {
				g.fillRect(p.x * cellSize, p.y * cellSize, cellSize, cellSize);
			}

			g.setColor(new Color(70, 70, 70));
			g.fillOval(food.x * cellSize, food.y * cellSize, cellSize, cellSize);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isGameOver) {
			move();
		}
		repaint();
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}
}
