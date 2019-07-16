package com.trello.UI.pages;

import com.trello.UI.core.Elem;
import org.openqa.selenium.By;

public class LabelPage {

    public Elem addLabelsBtn = new Elem (By.cssSelector(".js-edit-labels"));
    public Elem createLabelBtn= new Elem (By.cssSelector(".js-add-label"));
    public Elem labelNamefld=new Elem (By.cssSelector(".js-label-name"));
    public Elem submitCreationBtn=new Elem (By.cssSelector(".js-submit"));
    public Elem labelList = new Elem(By.cssSelector(".js-labels-list"));
    public Elem deleteLabelBtn = new Elem (By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div:nth-child(2) > div > div > form > div:nth-child(6) > div > input"));
    public Elem submitDeleteLabelBtn = new Elem (By.cssSelector("#chrome-container > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > input"));
public Elem closeBtn= new Elem(By.cssSelector(".pop-over-header-close-btn"));

    private Elem cardByUrlName (String urlName) {
        return new Elem(By.cssSelector(".list-card[href*='"+urlName+"']"),urlName);
    }

    public void open(String cardUrl){
        cardByUrlName(cardUrl).click();
        addLabelsBtn.click();
    }


    public void addLabel(String labelName){
        createLabelBtn.click();
        labelNamefld.type(labelName);
        submitCreationBtn.click();
    }

    public void changeLabel(String dataidlabel, String newName){
        labelList.find();
        Elem editLabelBtn=new Elem(By.cssSelector(".card-label-edit-button[data-idlabel*='"+dataidlabel+"']"));
        editLabelBtn.click();
        labelNamefld.type(newName);
        submitCreationBtn.click();
    }

    public void deleteLabel (String dataidlabel) {
        Elem editLabelBtn=new Elem(By.cssSelector(".card-label-edit-button[data-idlabel*='"+dataidlabel+"']"));
        editLabelBtn.click();

        deleteLabelBtn.click();
        submitDeleteLabelBtn.click();
    }


    public void closeLabelWindow() {
closeBtn.click();
    }
}
