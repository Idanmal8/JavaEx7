//idan malka 315655647.
public class DnaSequence {//this is the field property.
	private String sequence;
	private int[] nucleotideCounts;
	/**
	 * this is the default constructor .
	 * @param String sequence ,nucleotideCounts as an array.
	 * @return the sequence and the formatted array with +1 in each index for the proper character. */
	public DnaSequence() {
		sequence = "ACGT";
		nucleotideCounts = new int[sequence.length()];
		this.nucleotideCounts[0]=1;
		this.nucleotideCounts[1]=1;
		this.nucleotideCounts[2]=1;
		this.nucleotideCounts[3]=1;
	}/**
	 * this is the copy constructor .
	 * @param this.sequence as sequence , this.nucleotideCounts as the array.
	 */
	public DnaSequence(String sequence , int[] nucleotideCounts ) {
		this.sequence = sequence;
		this.nucleotideCounts = nucleotideCounts;
	}/**
	 * this private method is going over arr1 and adding arr2 to it summing the indexes.
	 * @param int i as the counter(going over the index) , arr1 ,arr2 as the required arrays.
	 *  @return arr1 as a new array with + arr2 . 
	 *  */
	private static void addArrayHelper(int i, int[] arr1, int[] arr2)
	{
		if (i == arr1.length)
			return;

		arr1[i] += arr2[i];
		addArrayHelper(i + 1, arr1, arr2);
	}
	/**
	 * this private method is a counter for the private property "nucleotideCounts" .
	 * @param int i as the runner on the indexes of the string .
	 * @return the array with counted characters that are valid .
	 * */
	private void counter(int i){
		if(i==this.sequence.length())
			return;
		if (this.sequence.charAt(i) == 'A' || this.sequence.charAt(i) == 'a') {
			this.nucleotideCounts[0]+=1;
		}else if (this.sequence.charAt(i) == 'C' || this.sequence.charAt(i) == 'c') {
			this.nucleotideCounts[1]+=1;
		}else if(this.sequence.charAt(i) == 'G' || this.sequence.charAt(i) == 'g') {
			this.nucleotideCounts[2]+=1;
		}else if(this.sequence.charAt(i) == 'T' || this.sequence.charAt(i) == 't') {
			this.nucleotideCounts[3]+=1;
		}
		counter(i+1);


	}
	/**
	 * this private method is checking if the sequence that implemented is valid.
	 * @param int i that goes over the indexes , sequence that is the string that was received .
	 * @return if the word is valid it returns true , if not false .
	 *  */
	private static boolean isValid(String sequence , int i ){
		if (i==sequence.length())
			return true;

		if (sequence.charAt(i) == 'A' || sequence.charAt(i) == 'a') {
			return true && isValid(sequence , i+1 );
		}
		else if (sequence.charAt(i) == 'C' || sequence.charAt(i) == 'c') {
			return true && isValid(sequence , i+1 );
		}
		else if(sequence.charAt(i) == 'G' || sequence.charAt(i) == 'g') {
			return true && isValid(sequence , i+1 );
		}
		else if(sequence.charAt(i) == 'T' || sequence.charAt(i) == 't') {
			return true && isValid(sequence , i+1 );
		}
		return false;



	}/**
	 * this method is checking if the sequence received is valid and if not giving it a default values .
	 * @param nucleotideCounts as the default array of checking the words count , a recursive action that checks if the word is valid. a default values
	 * @return this returns the word after check to the chosen method. 
	 * */
	public DnaSequence(String sequence) {

		this.nucleotideCounts = new int [4];

		if(isDnaSequence(sequence)) {
			this.sequence = sequence;
			counter(0);
		}
		else {
			this.sequence = "ACGT";
			this.nucleotideCounts[0]=1;
			this.nucleotideCounts[1]=1;
			this.nucleotideCounts[2]=1;
			this.nucleotideCounts[3]=1;
		}



	}/**
	 * this is the copy contractor .
	 * @param this.sequence , this.nucleotideCounts
	 * @return a copy as other.sequence , other.nucleotideCounts
	 *  */
	public DnaSequence(DnaSequence other) {
		this.sequence = other.sequence;
		this.nucleotideCounts = other.nucleotideCounts;
	}/**
	 * get method that receiving sequence */
	public String getSequence() {
		return this.sequence;
	}/**
	 * get method that receiving nucleotideCounts*/
	public int[] getNucleotideCounts() {
		return this.nucleotideCounts;
	}/**
	 * set method that set the sequence parameters.*/
	public void setSequence(String sequence) {
		this.sequence=sequence;
		this.nucleotideCounts = new int[4];
		counter(0);
	}/**
	checking if the sequence is valid . 
	 *@param sequence 
	 *@return the check of method isValid true or false.
	 **/
	public static boolean isDnaSequence(String sequence) {
		return isValid(sequence , 0);

	}/**
	 *this method changing the capital letters to small letters and the oppsite .
	 *@param string as blank , and recursive action to the method helper .
	 *@return the new sequence . 
	 **/
	public void changeCapitalization() {
		String newWord = "";
		if (isDnaSequence(this.sequence))
		{
			newWord = changeCapitalizationHelper(0, "");
		}

		this.sequence = newWord;
	}
	/**
	 * this method is checking each char of the sequence and replacing the capital characters with small letters and the oppsite .
	 * @param int i , string s .
	 * @return the new sequence to the method
	 * */
	private String changeCapitalizationHelper(int i, String s){
		if (i == this.sequence.length())
			return s;

		char c = this.sequence.charAt(i);

		if (c >= 'a' && c <= 'z')
			s+= (char)(c - 32);
		else
			s += (char)(this.sequence.charAt(i) + 32);

		return changeCapitalizationHelper(i + 1, s);


	}/**
	 * this method receive 2 arrays and adds the numbers of arr2 to arr1 and sum the indexes
	 * @param arr1 array , array arr2 .
	 * @return the new arr1 with new numbers .
	 * */
	public static boolean addArray(int[] arr1, int[] arr2) {
		if(arr1 == null || arr2 == null || arr1.length != arr2.length ) {
			return false;
		}

		addArrayHelper(0, arr1, arr2);
		return true;

	}/**
	* this method is checking the arrays of two sequences and adds them like in method 5
	* @param this.sequence and other.sequence 
	* @return the new array of them both .*/
	public void concatGenes(DnaSequence other) {
		this.sequence +=other.sequence;
		if(isValid(other.sequence , 0)) {
			addArray(this.nucleotideCounts , other.nucleotideCounts);
		}
	}/**
	* this is a string method that returns the sequence and the array validate .
	* @param info as string .
	* @return the sequence and the array as info . */
	public String toString() {
		String info = "";

		if(isDnaSequence(this.sequence)) {
			info = this.sequence + ": " + "(" + nucleotideCounts[0] + ", " + nucleotideCounts[1] + ", " + nucleotideCounts[2] + ", " + nucleotideCounts[3] + ")";
		}
		return info;
	}
}
