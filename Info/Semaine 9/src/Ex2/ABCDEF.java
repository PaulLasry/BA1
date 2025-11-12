package Ex2;

class A {
	public A() { }
}

class B extends A {
	public B() {
		super();
	}
}

class C extends B {
	public C() {
		super();
	}
}

class D extends A {
	protected int d = 1;

	public D(int x) {
		super();
		d = x;
	}

	public D() {
	}
}

class E extends D {
	public E() {
		super();
	}
}

class F extends D {
	public F() {
		super();
	}
}

class ABCDEF {
	public static void main(String[] args) {
		/*// Indiquez si les affectations suivantes sont correctes :
		A a = new A(); //
		B b = new B(); //
		C c = new C(); //
		D d = new D(); //
		E e = new E(); //
		F f = new F(); //

		a = b; //Oui car b est de types B mais aussi de types A
		b = a; //Non car b est de types B, sauf que A est de types A (seulement)
		a = (A) b; //Ca fonctionne aussi mais inutile
		a = null; //C'est possible
		null = a; //null n'a pas de types alors que a est de types A
		a = d; //Possible car a est de types A, d de types D et A
		b = d; //b est de type B, d de types D, il n'y a pas de lien d'héritage entre les deux
		a = e; //a est de type A, e de type E --> D --> A
		d = e; //d est de types D, e de type E --> D
        */
		// Remplissage d'un tableau:
		A[] as = new A[10];
		as[0] = new A();
		as[1] = new B();
		as[2] = new D(2);
		as[3] = new E();
		as[4] = new C();
		as[5] = new D(4);
		as[6] = new B();
		as[7] = new F();
		as[8] = new C();
		as[9] = new F();

		// Ex2.A vous d'ajouter le code de ces deux méthodes:
		rechercher(as);
		additionner(as);
	}

	private static void rechercher(A[] as) {
		int number =0;
        for(A a : as){
            if(a instanceof B){
                number++;
            }
        }
        System.out.println("Il y a " + number + " instances de la classe B");
	}

	private static void additionner(A[] as) {
        int number =0;
        for(A a : as){
            if(a instanceof D){
                number += ((D) a).d;
            }
        }
        System.out.println("Somme des variables d : " + number);
	}
}
