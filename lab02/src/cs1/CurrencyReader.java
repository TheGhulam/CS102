package cs1;
import java.util.ArrayList;
//class SimpleURLReader

public class CurrencyReader extends HTMLFilteredReader
{
  //properties
  final int LOC1 = 14;
  final int LOC2 = 13;
  double usdRate;
  String url;
  ArrayList<String> names;
  ArrayList<String> rates;
  ArrayList<Double> ratesD;
  ArrayList<String> finalRates;
  
  //constructors
  public CurrencyReader(String url)
  {
    super(url);
    this.url = url;
  }
  
  //methods
  
  public ArrayList<String> getCurrencies()
  {
    ArrayList<String> list = new ArrayList<String>();
    finalRates = new ArrayList<String>();
    names = new ArrayList<String>();
    rates = new ArrayList<String>();
    String data = super.getUnfilteredPageContents();
    int i = 0;
    
    while (data.indexOf("<CurrencyName>" , i) != -1)
    {
      names.add(data.substring(data.indexOf("<CurrencyName>" , i) + LOC1 , data.indexOf("<" , data.indexOf("<CurrencyName>" , i)  + LOC1)));
      rates.add(data.substring(data.indexOf("<ForexBuying>" , i) + LOC2 , data.indexOf("<" , data.indexOf("<ForexBuying>" , i)  + LOC2)));
     
      list.add(data.substring(data.indexOf("<CurrencyName>" , i) + LOC1 , data.indexOf("<" , data.indexOf("<CurrencyName>" , i)  + LOC1))
              + " :" + data.substring(data.indexOf("<ForexBuying>" , i) + LOC2 , data.indexOf("<" , data.indexOf("<ForexBuying>" , i)  + LOC2)));
      i = data.indexOf("<CurrencyName>" , i + 1) + 1;
    }
    names.remove(names.size() - 1);
    rates.remove(0);
    list.remove(list.size() - 1);
    getChangedRates();
    for (int k = 0; k < list.size(); k++)
    {
      finalRates.add(names.get(k) + " : " + ratesD.get(k));
    }
    //System.out.println(names + ""+ rates);
    //return list;
    return finalRates;
  }
  
  public void getChangedRates()
  {
    ArrayList<Double> list = new ArrayList<Double>();
    ratesD = new ArrayList<Double>();
    
    for (int i = 0; i < rates.size(); i++)
    {
      list.add(Double.parseDouble(rates.get(i)));
    }
    usdRate = list.get(0);
    
    for (int i = 0; i < rates.size(); i++)
    {
      ratesD.add(list.get(i) / usdRate);
    }
  }
  
  
}