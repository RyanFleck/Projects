import java.io.Serializable;

public class Recipe implements Serializable
{
    private String title,type,category,ingredients[];
    //private RecipeText recipeText;

    public Recipe(String title, String type, String category, String ingredients[])
    {
        this.title=title;
        this.type=type;
        this.category=category;
        this.ingredients=ingredients;
    }
    public String getTitle()
    {
        return title;
    }
    public String getType()
    {
        return type;
    }
    public String getCategory()
    {
        return category;
    }
    public String[] getIngredients()
    {
        return ingredients;
    }
    //public String getText(){return recipeText.getText(title);}
    public String getFilename()
    {
        return title.replaceAll(" ","_").toLowerCase();
    }
    public void setTitle(String newTitle)
    {
        title=newTitle;
    }
}

//TEST COMMENT TO MAKE SURE GIT IS WORKING
