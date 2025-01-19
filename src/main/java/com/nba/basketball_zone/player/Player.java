package com.nba.basketball_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {


    @Id
    @Column(name = "player", unique = true)
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private int age; 

    @Column(name = "team")
    private String team;

    @Column(name = "gp")
    private int games;

    @Column(name = "gs")
    private int gs;

    @Column(name = "mp")
    private double mp;

    @Column(name = "fg_percentage")
    private  double fgPercentage;

    @Column(name = "threep_percentage")
    private double threePtPercentage;

    @Column(name = "twop_percentage")
    private double twoPtPercentage;

    @Column(name = "ft_percentage")
    private double ftPercentage;

    @Column(name = "total_rebounds")
    private double trb;

    @Column(name = "assists")
    private double ast;

    @Column(name = "steals")
    private double stl;

    @Column(name = "blocks")
    private double blk;

    @Column(name = "turnovers")
    private double tov;

    @Column(name = "personal_fouls")
    private double pf;

    @Column(name = "points")
    private double pts;


    public Player(){
    }

    public Player(String name){
        this.name = name;
    }

    public Player(String name, String position, int age, String team, int games, int gs, double mp,  double fgPercentage, double threePtPercentage, double twoPtPercentage,
     double ftPercentage, double trb, double ast, double stl, double blk, double tov, double pf, double pts){
        this.name = name;
        this.position = position;
        this.age = age;
        this.team = team;
        this.games = games;
        this.gs = gs;
        this.mp = mp;
        this.fgPercentage = fgPercentage;
        this.threePtPercentage = threePtPercentage;
        this.twoPtPercentage = twoPtPercentage;
        this.ftPercentage = ftPercentage;
        this.trb = trb;
        this.ast = ast;
        this.stl = stl;
        this. blk = blk;
        this.tov = tov;
        this.pf = pf;
        this.pts = pts;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    public String getTeam(){
        return team;
    }

    public void setTeam(String team){
        this.team = team;
    }

    public int getGames(){
        return games;
    }

    public void setGames(int games){
        this.games = games;
    }

    public int getGs(){
        return gs;
    }

    public void setGs(int gs){
        this.gs = gs;
    }

    public double getMp(){
        return mp;
    }

    public void setMp(double mp){
        this.mp = mp;
    }

    public double getFgPercentage(){
        return fgPercentage;
    }

    public void setFgPercentage(double fgPercentage){
        this.fgPercentage = fgPercentage;
    }

    public double getThreePtPercentage(){
        return threePtPercentage;
    }

    public void setThreePtPercentage(double threePtPercentage){
        this.threePtPercentage = threePtPercentage;
    }

    public double getTwoPtPercentage(){
        return twoPtPercentage;
    }

    public void setTwoPtPercentage(double twoPtPercentage){
        this.twoPtPercentage = twoPtPercentage;
    }

    public double getFtPercentage(){
        return ftPercentage;
    }

    public void setFtPercentage(double ftPercentage){
        this.ftPercentage = ftPercentage;
    }

    public double getTrb(){
        return trb;
    }

    public void setTrb(double trb){
        this.trb = trb;
    }

    public double getAst(){
        return ast;
    }

    public void setAst(double ast){
        this.ast = ast;
    }

    public double getStl(){
        return stl;
    }

    public void setStl(double stl){
        this.stl = stl;
    }

    public double getBlk(){
        return blk;
    }

    public void setBlk(double blk){
        this.blk = blk;
    }

    public double getTov(){
        return tov;
    }

    public void setTov(double tov){
        this.tov = tov;
    }

    public double getPf(){
        return pf;
    }

    public void setPf(double pf){
        this.pf = pf;
    }

    public double getPts(){
        return pts;
    }

    public void setPts(double pts){
        this.pts = pts;
    }
    
}
