package markova.creature.human;

public class Name
{
    private String familyName;
    private final String personalName;
    private String patronymic;

    public Name(String personalName)
    {
        this(personalName, null, null);
    }

    public Name(String personalName, String familyName)
    {
        this(personalName, familyName, null);
    }

    public Name(String personalName, String familyName, String patronymic)
    {
        if (personalName != null && !personalName.isEmpty() ||
                familyName != null && !familyName.isEmpty() ||
                patronymic != null && !patronymic.isEmpty())
            throw new IllegalArgumentException("At least one argument must be initialized.");
        this.personalName = personalName;
        this.familyName = familyName;
        this.patronymic = patronymic;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getPersonalName() {
        return personalName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setFamilyName(String value) {
        familyName = value;
    }

    public void setPatronymic(String value) {
        patronymic = value;
    }

    @Override
    public String toString()
    {
        StringBuilder nameResult = new StringBuilder();
        if (isNotEmpty(familyName)) nameResult.append(familyName).append(" ");
        if (isNotEmpty(personalName)) nameResult.append(personalName).append(" ");
        if (isNotEmpty(patronymic)) nameResult.append(patronymic).append(" ");
        return nameResult.deleteCharAt(nameResult.length() - 1).toString();
    }

    private boolean isNotEmpty(String str)
    {
        return str != null && !str.isEmpty();
    }
}
