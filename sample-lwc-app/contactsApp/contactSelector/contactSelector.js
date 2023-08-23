import { LightningElement, wire } from 'lwc';
import getContactList from '@salesforce/apex/ContactController.getContactList';
import getAccounts from '@salesforce/apex/ContactController.getAccounts';

export default class ContactSelector extends LightningElement {
    contactOptions = [];
    error;

    @wire(getContactList)
    wiredContacts({ error, data }) {
        if (data) {
            this.contactOptions = data.map((record) => ({
                value: record.Id,
                label: record.Name
            }));
            this.error = undefined;
        } else if (error) {
            this.error = error;
            this.contactOptions = undefined;
        }
    }

    @wire(getAccounts)
    wiredAccounts({ error, data }) {
        if (data) {
            this.contactAccounts = data.map((record) => ({
                label: record.Name
            }));
            this.error = undefined;
        }
    }

    handleRecordSelected(event) {
        this.dispatchEvent(
            new CustomEvent('select', {
                detail: { recordId: event.target.value }
            })
        );
    }

    
}
