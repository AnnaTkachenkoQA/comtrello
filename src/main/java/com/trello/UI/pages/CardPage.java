package com.trello.UI.pages;

import com.trello.UI.core.Elem;
import org.openqa.selenium.By;

public class CardPage {

    public Elem addMemberBtn = new Elem(By.cssSelector(".js-change-card-members"));
    public Elem closeMemberBtn = new Elem(By.cssSelector(".pop-over-header-close-btn"));
    public Elem addOneMoreMemberBtn = new Elem (By.cssSelector("#chrome-container > div.window-overlay > div > div > div > div.window-main-col.mod-card-detail-icons-smaller > div.card-detail-data.u-gutter > div.card-detail-item.u-clearfix.js-card-detail-members > div > a > span"));
    public Elem addLabelsBtn = new Elem (By.cssSelector(".js-edit-labels"));
    public Elem addOneMoreLabelBtn = new Elem(By.cssSelector(".js-details-edit-labels"));

    public Elem checklistBtn= new Elem (By.cssSelector(".js-add-checklist-menu"));
    public Elem checklistNameFld = new Elem (By.cssSelector(".js-checklist-title"));
    public Elem addChecklistBtn= new Elem(By.cssSelector(".js-add-checklist"));

    public Elem addItemBtn= new Elem(By.cssSelector(".js-new-checklist-item-button"));
    public Elem checklistItemNameFld= new Elem(By.cssSelector(".js-new-checklist-item-input"));
    public Elem addChecklistItemBtn= new Elem(By.cssSelector(".js-add-checklist-item"));

    public Elem deleteChecklistBtn= new Elem (By.cssSelector(".js-confirm-delete"));
    public Elem confirmDeleteChecklistBtn= new Elem (By.cssSelector(".js-confirm"));

    public Elem addDueDate =new Elem (By.cssSelector(".js-add-due-date"));
    public Elem confirmDueDateBtn = new Elem (By.cssSelector("input[type=submit].wide"));

    public Elem addAttachmentBtn= new Elem (By.cssSelector("a.js-attach.button-link"));
    public Elem linkToAttachmentFld= new Elem (By.cssSelector(".attachment-add-link-input"));
    public Elem confirmAttachLinkBtn = new Elem (By.cssSelector(".js-add-attachment-url"));

    public Elem moveCardBtn = new Elem (By.cssSelector(".js-move-card"));
    public Elem selectListFld = new Elem (By.cssSelector(".js-select-list"));
    public Elem submitMovingBtn = new Elem (By.cssSelector(".primary.wide.js-submit"));

    public Elem closeCardBtn = new Elem(By.cssSelector(".dialog-close-button"));


    private Elem cardByUrlName (String urlName) {
        return new Elem(By.cssSelector(".list-card[href*='"+urlName+"']"),urlName);
    }

    public void open(String cardUrl){
        cardByUrlName(cardUrl).click();
    }


    //ADD TO CARD
    public void addMembers(String idMember){
        addMemberBtn.click();
        Elem member = new Elem(By.cssSelector(".js-select-member[idmember*='"+idMember+"']"));
        member.click();
        closeMemberBtn.click();
    }


    public void addOneMoreMember(String idMember) {
        addOneMoreMemberBtn.find().click();
        Elem member =new Elem(By.cssSelector(".js-select-member[idmember*='"+idMember+"']"));
        member.click();
        closeMemberBtn.click();
    }


    public void addLabels(String dataidlabel) {
        addLabelsBtn.click();
        Elem label = new Elem (By.cssSelector(".card-label[data-idlabel*='"+dataidlabel+"']"));
        label.find().click();
        closeMemberBtn.click();

    }

    public void addOneMoreLabel (String dataidlabel) {
        addOneMoreLabelBtn.click();
        Elem label = new Elem (By.cssSelector(".card-label[data-idlabel*='"+dataidlabel+"']"));
        label.find().click();
        closeMemberBtn.click();
    }

    public void addChecklist(String checklistName) {
        checklistBtn.click();
        checklistNameFld.type(checklistName);
        addChecklistBtn.click();
    }

    public void addItemToChecklist(String itemName){
        addItemBtn.click();
        checklistItemNameFld.type(itemName);
        addChecklistItemBtn.click();
    }

    //переделать!!!!!!!!!!!
    public void deleteChecklist(String checklistName) {
        deleteChecklistBtn.click();
        confirmDeleteChecklistBtn.click();
    }


    public void addDueDate(String dueDate){
        addDueDate.click();
        Elem dueDateFld = new Elem (By.cssSelector(".js-dpicker-date-input"));
        dueDateFld.type(dueDate);
        confirmDueDateBtn.click();
    }



    public void addAttachment(String linkToAttachment) {
        addAttachmentBtn.find().click();
        linkToAttachmentFld.type(linkToAttachment);
        confirmAttachLinkBtn.click();

    }

    ///////////////


    //ACTIONS
    public void move(String listName){
        moveCardBtn.click();
        selectListFld.click();
        Elem selectedListForMoving= new Elem (By.cssSelector(" select.js-select-list > option[text='"+listName+"']"));
        selectedListForMoving.click();
        submitMovingBtn.click();

    }


    public void copy (String listId) {}


    public void checkWatched() {

    }


    public void archiveSendToBoard() {

    }


    public void archiveDelete() {

    }


    public void share() {

    }

    /////////////////////////


    public void addDescription(String description){

    }

    public void addComment(String commentText){

    }


    public void showDetails () {

    }

    public void closeCardWindow(){
        closeCardBtn.click();
    }

}
