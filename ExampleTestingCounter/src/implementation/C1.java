package implementation;

public class C1 {
	void m1(int x) throws ValueTooSmallException{
		if(x < 0) {
			throw new ValueTooSmallException("val " + x);
		}
	}
}
