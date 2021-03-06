package com.myhand.cpucard;

/**
 * Created by wenha_000 on 2017-09-13.
 */

import com.myhand.shtcdatafile.FHFileRecord;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 CorpId	N11	营运单位代码
 LocalTxnSeq	N8	本地流水号
 TxnAttr	N2	交易性质	00-99
 StationId	N6	采集点编号
 PosOprId	N16	POS操作员编号	缺省值为全0
 PosCarrId	N6	POS机载体编号	公交车线路号
 TxnType	N2	交易类型	88/99/98/87/84/83/48/49/6B/6C/6E/81
 PosSeq	N12	POS机流水号
 CityCode	N4	城市代码
 CardFaceNum	N12	卡面号
 CardKind	N2	卡类型	00-99
 BalBef	N8	消费前卡余额
 TxnAmt	N8	交易金额
 TxnDate 	YYYYMMDD	交易发生日期
 TxnTime	hhmmss	交易发生时间
 TxnCounter	N6	交易计数器
 PosId	N8	POS机号
 TAC 	H8	交易认证码
 CardVerNo	N2	卡内版本号	当作地域区分标志

 */
public class DebitRecord implements Serializable{
    private String corpID;
    private long localTxnSeq;
    private byte txnAttr;
    private String stationID;
    private String oprID;
    private String busID;
    private byte txnType;
    private int posSeq;
    private String cityCode;
    private String cardFaceNum;
    private byte cardKind;
    private long balanceBef;
    private long amount;
    private String txnTime;
    private int txnCounter;
    private String posID;
    private String tac;
    private byte cardVerNo;
    private byte status;

    private Date lastUploadTime;
    public DebitRecord() {
    }

    public DebitRecord(String corpID,long localTxnSeq, byte txnAttr, String stationID, String oprID, String busID,byte txnType, int posSeq,
                       String cityCode, String cardFaceNum, byte cardKind, long balanceBef, long amount, String txnTime,
                       int txnCounter, String posID, String tac, byte cardVerNo,byte status) {
        this.corpID=corpID;
        this.localTxnSeq = localTxnSeq;
        this.txnAttr = txnAttr;
        this.stationID = stationID;
        this.oprID = oprID;
        this.busID = busID;
        this.txnType=txnType;
        this.posSeq = posSeq;
        this.cityCode = cityCode;
        this.cardFaceNum = cardFaceNum;
        this.cardKind = cardKind;
        this.balanceBef = balanceBef;
        this.amount = amount;
        this.txnTime = txnTime;
        this.txnCounter = txnCounter;
        this.posID = posID;
        this.tac = tac;
        this.cardVerNo = cardVerNo;
        this.status=status;
    }

    public Date getLastUploadTime() {
        return lastUploadTime;
    }

    public void setLastUploadTime(Date lastUploadTime) {
        this.lastUploadTime = lastUploadTime;
    }

    public String getCorpID() {
        return corpID;
    }

    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    public byte getStatus() {
        return status;
    }

    public byte getTxnType() {
        return txnType;
    }

    public void setTxnType(byte txnType) {
        this.txnType = txnType;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public long getLocalTxnSeq() {
        return localTxnSeq;
    }

    public void setLocalTxnSeq(long localTxnSeq) {
        this.localTxnSeq = localTxnSeq;
    }

    public byte getTxnAttr() {
        return txnAttr;
    }

    public void setTxnAttr(byte txnAttr) {
        this.txnAttr = txnAttr;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getOprID() {
        return oprID;
    }

    public void setOprID(String oprID) {
        this.oprID = oprID;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public int getPosSeq() {
        return posSeq;
    }

    public void setPosSeq(int posSeq) {
        this.posSeq = posSeq;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCardFaceNum() {
        return cardFaceNum;
    }

    public void setCardFaceNum(String cardFaceNum) {
        this.cardFaceNum = cardFaceNum;
    }

    public byte getCardKind() {
        return cardKind;
    }

    public void setCardKind(byte cardKind) {
        this.cardKind = cardKind;
    }

    public long getBalanceBef() {
        return balanceBef;
    }

    public void setBalanceBef(long balanceBef) {
        this.balanceBef = balanceBef;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public int getTxnCounter() {
        return txnCounter;
    }

    public void setTxnCounter(int txnCounter) {
        this.txnCounter = txnCounter;
    }

    public String getPosID() {
        return posID;
    }

    public void setPosID(String posID) {
        this.posID = posID;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public byte getCardVerNo() {
        return cardVerNo;
    }

    public void setCardVerNo(byte cardVerNo) {
        this.cardVerNo = cardVerNo;
    }

    public FHFileRecord toFHFileRecord(String unitCode)
    {
        FHFileRecord result=new FHFileRecord(unitCode,localTxnSeq,stationID,txnAttr,
                posSeq,cityCode,cardFaceNum,cardKind,
                balanceBef,amount,txnTime,txnCounter,posID,tac,cardVerNo);
        return result;
    }
}
