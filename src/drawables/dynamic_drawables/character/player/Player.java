package drawables.dynamic_drawables.character.player;

import drawables.dynamic_drawables.bullet.Bullet;
import drawables.dynamic_drawables.character.Character;
import drawables.static_drawables.coin.Coin;
import drawables.static_drawables.health_aid.HealthAid;
import drawables_observers.dynamic_drawables.PlayerObserver;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bassam on 12/8/2017.
 */
public abstract class Player extends Character {

    public static final String KEY_PLAYER_NAME = "player-name";
    public static final String KEY_PLAYER_SCORE = "player-score";
    public static final String KEY_PLAYER_MAXIMUM_HEALTH = "player-maximum-health";

    public static final int PLAYER_TYPE_KNIGHT = 0;
    public static final int PLAYER_TYPE_PRINCESS = 1;
    public static final String DEFAULT_PLAYER_NAME = "Anonymous";
    private static final double DEFAULT_PLAYER_HEALTH = 100;
    private static final double DEFAULT_PLAYER_SCORE = 0;
    private static final double DEFAULT_MAX_PLAYER_HEALTH = DEFAULT_PLAYER_HEALTH;
    private static final int DEFAULT_MAX_NUMBER_OF_BULLETS = 6;
    private static final String PLAYERS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "players\\Characters";

    private int playerType;
    private String playerName;

    private double playerScore;
    private double maximumPlayerHealth;
    private List<Bullet> playerBullets;
    private int maxNumberOfBullets;

    public Player(int playerType) {
        super(Character.CHAR_TYPE_PLAYER);
        this.playerType = playerType;
        this.playerName = DEFAULT_PLAYER_NAME;
        this.playerScore = DEFAULT_PLAYER_SCORE;
        this.maximumPlayerHealth = DEFAULT_MAX_PLAYER_HEALTH;
        this.playerBullets = new LinkedList<>();
        this.maxNumberOfBullets = DEFAULT_MAX_NUMBER_OF_BULLETS;
        setCharacterHealth(DEFAULT_PLAYER_HEALTH);
        addObserver(new PlayerObserver());
    }

    public static String getPlayersAssetsDirectory() {
        return PLAYERS_ASSETS_DIRECTORY;
    }

    public double getPlayerScore() {
        return playerScore;
    }

    private void setPlayerScore(double playerScore) {
        this.playerScore = playerScore;
        notifyObserversWithKey(KEY_PLAYER_SCORE);
    }

    public double addScore(double scoreToAdd) {
        if (scoreToAdd >= 0) {
            setPlayerScore(playerScore + scoreToAdd);
        }
        return getPlayerScore();
    }

    public boolean hasBullets() {
        return playerBullets.size() != 0;
    }

    public void addBullet(Bullet bullet) {
        if (playerBullets.size() >= DEFAULT_MAX_NUMBER_OF_BULLETS) {
            return;
        }
        playerBullets.add(bullet);
    }
    //added by Alaaaa
    public List<Bullet> getAllBullets() {
        return playerBullets;
    }
    //added by Alaaaa
    public void addBullets(List<Bullet> bullets) {
    	for (int i = 0; i < bullets.size(); i++) {
    		if (playerBullets.size() >= DEFAULT_MAX_NUMBER_OF_BULLETS) {
                return;
            }
            playerBullets.add(bullets.get(i));
    	}
    }

    public Bullet getNextBullet() {
        Bullet bullet = null;
        if (hasBullets()) {
            bullet = playerBullets.get(0);
            playerBullets.remove(0);
        }
        return bullet;
    }

    public double addCoinScore(Coin coin) {
        return addScore(coin.getCoinValue());
    }

    public double addHealth(double healthAmount) {
        double totalHealth = healthAmount + getCharacterHealth();
        if (totalHealth > getMaximumPlayerHealth()) {
            totalHealth = getMaximumPlayerHealth();
        }
        setCharacterHealth(totalHealth);
        return getCharacterHealth();
    }

    public double addHealthAid(HealthAid healthAid) {
        return addHealth(healthAid.getHealthAmount());
    }

    public double removeScore(double scoreToRemove) {
        if (scoreToRemove <= 0) {
            setPlayerScore(playerScore - scoreToRemove);
        }
        return getPlayerScore();
    }

    public int getPlayerType() {
        return playerType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        notifyObserversWithKey(KEY_PLAYER_NAME);
    }

    public double getMaximumPlayerHealth() {
        return maximumPlayerHealth;
    }

    protected void setMaximumPlayerHealth(double maximumPlayerHealth) {
        this.maximumPlayerHealth = maximumPlayerHealth;
        notifyObserversWithKey(KEY_PLAYER_MAXIMUM_HEALTH);
    }

    public int getMaxNumberOfBullets() {
        return maxNumberOfBullets;
    }

    public void setMaxNumberOfBullets(int maxNumberOfBullets) {
        this.maxNumberOfBullets = maxNumberOfBullets;
    }

    public double decreaseHealth(double healthAmount) {
        double totalHealth = getCharacterHealth() - healthAmount;
        if (totalHealth < 0) {
            totalHealth = 0;
        }
        setCharacterHealth(totalHealth);
        return getCharacterHealth();
    }
}
