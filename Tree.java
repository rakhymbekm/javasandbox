public class Tree {
	public static void main(String[] args) {

		int bottomLength = 15;

		int bottomMiddle = bottomLength / 2;
		
		outerloop: for (int i = 0; i < bottomLength; i++) {

			for (int j = bottomLength; j >= 0; j--) {

				if (!(bottomMiddle+i>=bottomLength)) {

					if (j >= bottomMiddle && 
						j <= bottomMiddle + i || 
						j >= bottomMiddle - i && 
						j <= bottomMiddle) {

						System.out.print("*");
					
					} else {
						System.out.print(" ");
					}

				} else {
					break outerloop;				
				}

			}

			System.out.println();

		}
	}
}