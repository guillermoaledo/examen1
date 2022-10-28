package ies.vegademijas.genericos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bag <T>{
	
	private ArrayList<T> lista;
	
	public Bag() {
		lista = new ArrayList<>();
	}
	
	public void add(T e) {
		lista.add(e);
	}
	
	public void add(T e, int n) {
		for (int i = 0; i < n; i++) {
			lista.add(e);
		}
	}
	
	public int getCount(T e) {
		int count = 0;
		
		for(T elem : lista) {
			if(elem.equals(e)) {
				count++;
			}
		}
		
		return count;
	}
	
	public void remove(T e) {
		for(int i = 0; i < this.getCount(e); i++) {
			if(e.equals(lista.get(i))) {
				lista.remove(i);
				//Necesito restar 1 a i para que cuando se elimine un elemento, no se salte el siguiente
				i--;
			}
		}
	}
	
	public void remove(T e, int n) {
		int count = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(e.equals(lista.get(i)) && count != n) {
				lista.remove(i);
				count++;
				i--;
			}
		}
	}
	
	public int size() {
		return lista.size();
	}
	
	public Set<T> uniqueSet() {
		Set<T> set = new HashSet<>();
		set.addAll(lista);
		
		return set;
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
}
