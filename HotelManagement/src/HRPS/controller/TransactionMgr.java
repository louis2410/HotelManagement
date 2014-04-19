package HRPS.controller;

import HRPS.entity.Transaction;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransactionMgr implements Manager {

    private double promoRate;
    private double gstRate;
    private ArrayList<Transaction> arrayTransaction;
    private PersistenceStrategy strategy;
    private List datalist;

    //Constructor
    public TransactionMgr() {
        arrayTransaction = new ArrayList<Transaction>();
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Transaction"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        //Store data to array
        this.setup();
        
        this.promoRate = 0.05;
        this.gstRate = 0.07;
    }

    public TransactionMgr(int promo, int gst) {
        arrayTransaction = new ArrayList<Transaction>();
        // prepares the file strategy to Respecitve data directory 
        strategy = new FilePersistenceStrategy(new File(System.getProperty("user.dir") + "/src/HRPS/data/Transaction"));
        // creates the list and linkage to data directory
        datalist = new XmlArrayList(strategy);
        //Store data to array
        this.setup();
        this.promoRate = promo;
        this.gstRate = gst;
    }

    public double getPromoRate() {
        return this.promoRate;
    }

    public void setPromoRate(double promoRate) {
        this.promoRate = promoRate;
    }

    public double getGstRate() {
        return this.gstRate;
    }

    public void setGstRate(double gstRate) {
        this.gstRate = gstRate;
    }

    public boolean createTransaction(Transaction transaction) {
         try {
            arrayTransaction.add(transaction);
        } catch (Exception ex) {
            System.out.println("Failed to create " + transaction.getTransactionId() + " to data directory");
            return false;
        }
        return true;
    }

    public void getTransaction(int transactionId) {
        // TODO - implement TransactionMgr.getTransaction
        throw new UnsupportedOperationException();
    }
    
    public double applyTaxPromoRates(double roomPrice, double roomServicePrice){
        double finalPrice = 0.0;
        
        roomPrice = roomPrice - (roomPrice  * this.promoRate);
        roomServicePrice += roomServicePrice - (roomServicePrice * this.promoRate);
        
        finalPrice = roomPrice + (roomPrice  * this.gstRate);
        finalPrice += roomServicePrice + (roomServicePrice * this.gstRate);
        return finalPrice;
    }
    
    public String generateTransId() {
        return "T" + (arrayTransaction.size() + 1);
    }
    
    public Transaction createNewLog(){
        Transaction trans = new Transaction(generateTransId());
        this.createTransaction(trans);
        return trans;
    }

    @Override
    public boolean createToFile() {
        try {
            for (Iterator it = arrayTransaction.iterator(); it.hasNext();) {
                Transaction transaction = (Transaction) it.next();
                datalist.add(transaction);
            }
        } catch (Exception ex) {
            System.out.println("Failed to write to data directory");
            return false;
        }
        return true;
    }

    @Override
    public boolean retrieveFromFile() {
        try {
            //for each reservation in reservation folder, creates an reservation object in reservationarray
        for (Iterator it = datalist.iterator(); it.hasNext();) {
            Transaction transaction = (Transaction) it.next();
            arrayTransaction.add(transaction);
        }
        } catch (Exception ex) {
            System.out.println("Failed to retrive all from data directory");
            return false;
        }
        System.out.println("XML To Reservation Complete");
        return true;
    }

    @Override
    public boolean deleteFromFile() {
         try {
            //for each guest in Guest folder, delete each
            for (Iterator it = datalist.iterator(); it.hasNext();) {
                 Transaction transaction = (Transaction) it.next();
                it.remove();
            }
        } catch (Exception ex) {
            System.out.println("Failed to delete all from data directory");
            return false;
        }
        return true;
    }

    @Override
    public void setup() {
       this.retrieveFromFile();
    }
}