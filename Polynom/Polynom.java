package Polynom;

import java.util.*;

public class Polynom {

    private ArrayList<Ele> myEle;
	private int [] cons;
    private int [] power;
    
    private int maxSize;
    private int[] c;
    private int[] p;
    private int newIndex;
	private Ele tempThis, tempPol;
	int tempThisC, tempThisP, tempPolP, tempPolC;
	private int indexThis=0, IndexPol=0;
	private int temp;

	public Polynom(int[] cons, int[] power) throws Exception {
		this.cons = cons;
		this.power = power;
		
		myEle = new ArrayList<Ele>();
		
		int consLength = cons.length;
		int powerLength = power.length;
		int tempCons;
		int tempPower;
		
		if(consLength != powerLength) {
			throw new Exception("EROR: Arrays are not in the same length");
		}else {
			
			for(int i=0; i<powerLength; i++) { // rearrange the arrays according to order
				for(int j=0; j<powerLength; j++) {
					if(power[i]>power[j]) {
						tempPower = power[i]; //swap
						tempCons = cons[i];
						power[i] = power[j];
						cons[i] = cons[j];
						power[j] = tempPower;
						cons[j] = tempCons;
					}
				}
			}
			
			for(int i=0; i<consLength; i++) {
				myEle.add(new Ele(cons[i], power[i]));
			}
//			this.toString();
		}	
	}
	
	public Polynom plus(Polynom polynom) throws Exception {
		maxSize = this.myEle.size() + polynom.myEle.size(); //max size for the arrays of the new polynom
		
		//for the new polynom
		c = new int[maxSize];
		p = new int[maxSize];
		newIndex=0;
		
		indexThis=0;
		IndexPol=0;
		
		//loop adding to the arrays of new polynom 
		while((this.myEle.size() > indexThis) && (polynom.myEle.size() > IndexPol)) {
			tempThis = this.myEle.get(indexThis);
			tempPol = polynom.myEle.get(IndexPol);
			
			if(tempThis.getPower() > tempPol.getPower()) {
				c[newIndex]=tempThis.getCons();
				p[newIndex]=tempThis.getPower();
				indexThis++;
				newIndex++;
			}else if(tempThis.getPower() < tempPol.getPower()) {
				c[newIndex]=tempPol.getCons();
				p[newIndex]=tempPol.getPower();
				IndexPol++;
				newIndex++;
			}else { //power is equal
				c[newIndex]=tempThis.getCons() + tempPol.getCons();
				p[newIndex]=tempPol.getPower();
				IndexPol++;
				indexThis++;
				newIndex++;
			}
		}
		
		//in case one polynom is ended, we will add the rest of elements that left
		if(this.myEle.size() == indexThis) {
			while(polynom.myEle.size() < IndexPol) {
				tempPol = polynom.myEle.get(IndexPol);
				c[newIndex]=tempPol.getCons();
				p[newIndex]=tempPol.getPower();
				IndexPol++;
				newIndex++;
			}
		}else {
			while(this.myEle.size() > indexThis) {
				tempThis = this.myEle.get(indexThis);
				c[newIndex]=tempThis.getCons();
				p[newIndex]=tempThis.getPower();
				indexThis++;
				newIndex++;
			}
		}
		
		Polynom newPolynom = new Polynom(c, p);
		return newPolynom;
	}
		
	public Polynom minus(Polynom polynom) throws Exception {
		maxSize = this.myEle.size() + polynom.myEle.size(); //max size for the arrays of the new polynom
		
		//for the new polynom
		c = new int[maxSize];
		p = new int[maxSize];
		newIndex=0;
		
		indexThis=0;
		IndexPol=0;
		
		//loop subscribing the arrays of new polynom 
		while((this.myEle.size() > indexThis) && (polynom.myEle.size() > IndexPol)) {
			tempThis = this.myEle.get(indexThis);
			tempPol = polynom.myEle.get(IndexPol);
			
			if(tempThis.getPower() > tempPol.getPower()) {
				c[newIndex]=tempThis.getCons();
				p[newIndex]=tempThis.getPower();
				indexThis++;
				newIndex++;
			}else if(tempThis.getPower() < tempPol.getPower()) {
				c[newIndex]=(tempPol.getCons())*(-1);
				p[newIndex]=tempPol.getPower();
				IndexPol++;
				newIndex++;
			}else { //power is equal
				c[newIndex]=tempThis.getCons() - tempPol.getCons();
				p[newIndex]=tempPol.getPower();
				IndexPol++;
				indexThis++;
				newIndex++;
			}
		}
		
		//in case one polynom is ended, we will add the rest of elements that left
		if(this.myEle.size() == indexThis) {
			while(polynom.myEle.size() < IndexPol) {
				tempPol = polynom.myEle.get(IndexPol);
				c[newIndex]=tempPol.getCons();
				p[newIndex]=tempPol.getPower();
				IndexPol++;
				newIndex++;
			}
		}else {
			while(this.myEle.size() > indexThis) {
				tempThis = this.myEle.get(indexThis);
				c[newIndex]=tempThis.getCons();
				p[newIndex]=tempThis.getPower();
				indexThis++;
				newIndex++;
			}
		}
		
		Polynom newPolynom = new Polynom(c, p);
		return newPolynom;
	}
	
	public Polynom Nigzeret() throws Exception {
		c = new int[this.myEle.size()];
		p = new int[this.myEle.size()];
		Polynom newP;
		
		for(int k=0; k<this.cons.length; k++) {//loop for saving the power and calculating the new item in the polynom
			Ele tempEle = this.myEle.get(k);
			temp = tempEle.getPower();
			p[k] = temp - 1;
			c[k] = tempEle.getCons() * temp;
		}
	
		newP = new Polynom(c, p);
		return newP;

	}

	public String toString() {
		for(int k=0; k<myEle.size(); k++) {
			Ele ele = this.myEle.get(k);
			if((ele.getPower() != 0) || (ele.getCons() != 0)) {
				if((k != 0) && (ele.getCons() > 0))
					System.out.print("+");
				System.out.print(ele.getCons()+"x^"+ele.getPower());
			}
		}
		System.out.println();
		return null;
	}
	
	public boolean equals(Polynom p) {
		if(p.myEle.size()!=this.myEle.size()) { //in case ths polynom are not in the same size
			System.out.println("False");
			return false;
		}
		for(int k=0; k<this.myEle.size(); k++) { //checking all items of polynoms
			Ele ele1 = this.myEle.get(k);
			Ele ele2 = p.myEle.get(k);
			if(!(ele1.getCons()==ele2.getCons() && ele1.getPower()==ele2.getPower())) {
				System.out.println("False");
				return false;
			}
		}
		System.out.println("True");
		return true;	
	}
	
	public boolean isZero(int x, int y) { //helping method
		if(x+y == 0)
			return true;
		else
			return false;
	}
	

}
