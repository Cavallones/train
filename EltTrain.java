public class EltTrain
{
	protected String nom;
	protected int poids;

	EltTrain()
	{
		this.nom = "train";
		this.poids = 0;
	}

	EltTrain(String a, int b)
	{
		this.nom = a;
		this.poids = b;
	}

	public static void main(String[] args)
	{

	}
}

class Locomotive extends EltTrain
{
	protected final double poidMax;
	private int joursDepuisDerniereVisite;

	Locomotive()
	{
		super();
		this.poidMax = 4000;
		this.joursDepuisDerniereVisite = 0;
	}

	Locomotive(String nom, int poid, int poidMax, int nbjour)
	{
		super(nom, poid);
		this.poidMax = poidMax;
		this.joursDepuisDerniereVisite = nbjour;
	}

	public boolean peutTracter(double poidAjouter)
	{
		if(this.poids + poidAjouter <= this.poidMax)
		{
			return true;
		}
		return false;
	}

	public void inspectionOK()
	{
		this.joursDepuisDerniereVisite = 0;
	}

	public boolean peutRouler()
	{
		if(this.joursDepuisDerniereVisite < 30)
		{
			this.inspectionOK();
			return true;
		}
		return false;
	}
}

class Wagon extends EltTrain
{
	protected final int nbMaxDeGens;
	protected int placesReserve;

	Wagon()
	{
		super();
		this.nbMaxDeGens = 50;
		this.placesReserve = 0;
	}

	public boolean reserver(int n)
	{
		if(this.placesReserve + n <= nbMaxDeGens)
		{
			this.placesReserve = this.placesReserve + n;
			return true;
		}
		return false;
	}

	public int calulerPoid()
	{
		return this.poids = this.placesReserve * 75 + 1000; //On suppose 1000kg le poids du wagon vide
	}
}

class WagonBar extends Wagon
{
	private int nbGensPresents;

	WagonBar()
	{
		super();
		this.nbGensPresents = 0;
	}
	public int calculerPoid()
	{
		return this.poids = this.nbGensPresents * 75 + 1000;
	}
}

class Autorail extends EltTrain
{
	protected int nbGens;
	protected int nbMaxDeGens;


	Autorail()
	{
		super();
		this.nbGens = 50;
		this.nbMaxDeGens = 100;
	}

	public boolean reserver(int n)
	{
		if(this.nbGens + n <= nbMaxDeGens)
		{
			this.nbGens = this.nbGens + n;
			return true;
		}
		return false;
	}

	public int calculerPoid()
	{
		return this.poids = this.nbGens * 75 + 1000;
	}
}
