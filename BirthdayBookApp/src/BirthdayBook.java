
public class BirthdayBook {
	private final int MAX_CAPACITY = 10;
	private Entry[] entries;
	private int numEntries;

	public BirthdayBook() {
		entries = new Entry[MAX_CAPACITY];
		numEntries = 0;
	}

	public int getNumberOfEntries() {
		return numEntries;
	}

	public Entry[] getEntries() { // entries a
		Entry[] es = new Entry[numEntries]; // stores new entries
		for (int i = 0; i < numEntries; i++) {
			es[i] = entries[i];
		}
		return es;
	}

	public String toString() {
		String tempString = "";
		for (int i = 0; i < numEntries; i++) {
			tempString = tempString + "\n" + entries[i].toString();
		}
		return "There are " + numEntries + " entries in the book" + tempString;
	}

	private int indexOf(String name) {
		int index = -1;

		for (int i = 0; i < numEntries; i++) {
			Entry e = entries[i];
			if (e.getName().equals(name)) {
				return i;
			}
		}
		return index;
	}

	public boolean nameExists(String name) {
		int index;
		index = indexOf(name);
		return index >= 0;
	}

	public Birthday getBirthday(String s) {
		int index = indexOf(s);
		if (index >= 0) {
			return entries[index].getBirthday();
		} else {
			return null;
		}
	}

	public String[] getReminders(Birthday birthday) { // returns array of everyone born on this date
		int numReminder = 0;
		for (int i = 0; i < numEntries; i++) { //first find how many items
			if (entries[i].getBirthday().equals(birthday)) {
				numReminder++;
			}
		}
		
		String[] reminders = new String[numReminder];

		int count = 0;//count stores location of remainders array
		for (int i = 0; i < numEntries; i++) { //then put the items in remainders array
			if (entries[i].getBirthday().equals(birthday)) {
				reminders[count] = entries[i].getName();
				count++;
			}
		}
		return reminders;
	}

	public String[] getReminders(int month, int day) { // returns array of everyone born on this date
		Birthday birthday = new Birthday(month, day);
		int numReminder = 0;
		for (int i = 0; i < numEntries; i++) {
			if (entries[i].getBirthday().equals(birthday)) {
				numReminder++;
			}
		}
		String[] reminders = new String[numReminder];

		int count = 0;
		for (int i = 0; i < numEntries; i++) {
			if (entries[i].getBirthday().equals(birthday)) {
				reminders[count] = entries[i].getName();
				count++;
			}
		}
		return reminders;
	}

	public void removeEntry(String name) {
		int index = indexOf(name);
		if (index >= 0) { // removes if there is entries to remove
			for (int i = index; i < numEntries - 1; i++) {
				this.entries[i] = this.entries[i + 1];
			}
			this.entries[numEntries-1] = null;
			numEntries --;
		}
	}

	public void addEntry(String name, Birthday birthday) {
		int index = indexOf(name);
		if (index == -1) { // name doesn't already exist
			this.entries[numEntries] = new Entry(name, birthday);
			numEntries++;
		}else { //name exists and replaces 
			this.entries[index].setBirthday(birthday);
		}
	}

	public void addEntry(String name, int month, int day) {
		int index = indexOf(name);
		if (index == -1) { // name doesnt already exist
			entries[numEntries] = new Entry(name, month, day);
			numEntries++;
		}else {
			this.entries[index].setBirthday(month, day);
		}
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		BirthdayBook other = (BirthdayBook) obj;
		boolean isEqual = this.getNumberOfEntries() == other.getNumberOfEntries();
		if (!isEqual) {
			return false;
		}
		
		for (int i = 0; i < numEntries; i ++) {
			isEqual = this.entries[i].equals(other.entries[i]);
			if (!isEqual) {
				return false;
			}
		}
		return true;		
	}
}
