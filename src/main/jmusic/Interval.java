package main.jmusic;

public class Interval {
    private final int tonic;
    private Note[] notes;

    public Interval(int tonic, String interval, float duration) {
        this.tonic = tonic;
        parseInterval(interval, 64, duration);
    }

    public Interval(int tonic, String interval, int velocity, float duration) {
        this.tonic = tonic;
        parseInterval(interval, velocity, duration);
    }

    private void parseInterval(String interval, int velocity, float duration) {
        switch(interval) {
            default:
            case "P1":
                notes = new Note[1];
                notes[0] = new Note(tonic, velocity, duration);
                break;
            case "m2":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 1, velocity, duration);
                break;
            case "M2":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 2, velocity, duration);
                break;
            case "m3":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 3, velocity, duration);
                break;
            case "M3":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 4, velocity, duration);
                break;
            case "P4":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 5, velocity, duration);
                break;
            case "TT":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 6, velocity, duration);
                break;
            case "P5":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 7, velocity, duration);
                break;
            case "m6":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 8, velocity, duration);
                break;
            case "M6":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 9, velocity, duration);
                break;
            case "m7":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 10, velocity, duration);
                break;
            case "M7":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 11, velocity, duration);
                break;
            case "P8":
                notes = new Note[2];
                notes[0] = new Note(tonic, velocity, duration);
                notes[1] = new Note(tonic + 12, velocity, duration);
                break;
        }
    }

    public Note[] getNotes() {
        return notes;
    }
}