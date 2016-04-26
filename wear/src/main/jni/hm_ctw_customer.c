
#include "hm_ctw_customer.h"
#include "hm_cert.h"
#include <string.h>
#include "hm_config.h"
#include "hmbtcore.h"
#include "hm_ctw_api.h"

void hm_ctw_init()
{

}

void hm_ctw_ping()
{

}

void hm_ctw_authorised_device_added(hm_device_t *device, uint8_t error)
{

}

void hm_ctw_authorised_device_updated(hm_device_t *device, uint8_t error)
{

}

void hm_ctw_entered_proximity(hm_device_t *device)
{
    jclass cls = (*envRef)->FindClass(envRef, "com/high_mobility/btcore/HMDevice");
    jmethodID constructor = (*envRef)->GetMethodID(envRef,cls, "<init>", "()V");
    jmethodID setMac = (*envRef)->GetMethodID(envRef,cls, "setMac", "([B)V");
    jmethodID setSerial = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");
    jmethodID setIsAuthenticated = (*envRef)->GetMethodID(envRef,cls, "setIsAuthorised", "(I)V");
    jmethodID setAppId = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");

    (*envRef)->CallVoidMethod(envRef, cls, setMac, device->mac);
    (*envRef)->CallVoidMethod(envRef, cls, setSerial, device->serial_number);
    (*envRef)->CallVoidMethod(envRef, cls, setIsAuthenticated, device->is_authorised);
    (*envRef)->CallVoidMethod(envRef, cls, setAppId, device->app_id);

    jobject obj = (*envRef)->NewObject(cls, constructor,NULL);


    return (*envRef)->CallVoidMethod(envRef, coreInterfaceRef, interfaceMethodHMCtwEnteredProximity, obj);
}

void hm_ctw_proximity_measured(hm_device_t *device, uint8_t receiver_count, hm_receiver_t *receivers)
{

}

void hm_ctw_exited_proximity(hm_device_t *device)
{
    jclass cls = (*envRef)->FindClass(envRef, "com/high_mobility/btcore/HMDevice");
    jmethodID constructor = (*envRef)->GetMethodID(envRef,cls, "<init>", "()V");
    jmethodID setMac = (*envRef)->GetMethodID(envRef,cls, "setMac", "([B)V");
    jmethodID setSerial = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");
    jmethodID setIsAuthenticated = (*envRef)->GetMethodID(envRef,cls, "setIsAuthorised", "(I)V");
    jmethodID setAppId = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");

    (*envRef)->CallVoidMethod(envRef, cls, setMac, device->mac);
    (*envRef)->CallVoidMethod(envRef, cls, setSerial, device->serial_number);
    (*envRef)->CallVoidMethod(envRef, cls, setIsAuthenticated, device->is_authorised);
    (*envRef)->CallVoidMethod(envRef, cls, setAppId, device->app_id);

    jobject obj = (*envRef)->NewObject(cls, constructor,NULL);


    return (*envRef)->CallVoidMethod(envRef, coreInterfaceRef, interfaceMethodHMCtwExitedProximity, obj);
}

void hm_ctw_command_received(hm_device_t *device, uint8_t *data, uint8_t *length, uint8_t *error)
{
    jclass cls = (*envRef)->FindClass(envRef, "com/high_mobility/btcore/HMDevice");
    jmethodID constructor = (*envRef)->GetMethodID(envRef,cls, "<init>", "()V");
    jmethodID setMac = (*envRef)->GetMethodID(envRef,cls, "setMac", "([B)V");
    jmethodID setSerial = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");
    jmethodID setIsAuthenticated = (*envRef)->GetMethodID(envRef,cls, "setIsAuthorised", "(I)V");
    jmethodID setAppId = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");

    (*envRef)->CallVoidMethod(envRef, cls, setMac, device->mac);
    (*envRef)->CallVoidMethod(envRef, cls, setSerial, device->serial_number);
    (*envRef)->CallVoidMethod(envRef, cls, setIsAuthenticated, device->is_authorised);
    (*envRef)->CallVoidMethod(envRef, cls, setAppId, device->app_id);

    jobject obj = (*envRef)->NewObject(cls, constructor,NULL);

    jbyteArray data_ = (*envRef)->NewByteArray(envRef,300);
    (*envRef)->SetByteArrayRegion(envRef, data_, 0, *length, (const jbyte*) data );

    jintArray length_ = (*envRef)->NewIntArray(envRef,1);
    (*envRef)->SetIntArrayRegion(envRef, length_, 0, 1, (const jint*) length );

    jintArray error_ = (*envRef)->NewIntArray(envRef,1);
    (*envRef)->SetIntArrayRegion(envRef, error_, 0, 1, (const jint*) error );

    (*envRef)->CallVoidMethod(envRef, coreInterfaceRef, interfaceMethodHMCtwCustomCommandReceived, obj,data_,length_,error_);

    jint* length_array = (*envRef)->GetIntArrayElements(envRef, length_, NULL);
    *length = length_array[0];

    jint* error_array = (*envRef)->GetIntArrayElements(envRef, error_, NULL);
    *error = error_array[0];

    jbyte* data_array = (*envRef)->GetByteArrayElements(envRef, data_, NULL);
    memcpy(data,data_array,length_array[0]);
}

uint32_t hm_ctw_get_device_certificate_failed(hm_device_t *device, uint8_t *nonce)
{
    jclass cls = (*envRef)->FindClass(envRef, "com/high_mobility/btcore/HMDevice");
    jmethodID constructor = (*envRef)->GetMethodID(envRef,cls, "<init>", "()V");
    jmethodID setMac = (*envRef)->GetMethodID(envRef,cls, "setMac", "([B)V");
    jmethodID setSerial = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");
    jmethodID setIsAuthenticated = (*envRef)->GetMethodID(envRef,cls, "setIsAuthorised", "(I)V");
    jmethodID setAppId = (*envRef)->GetMethodID(envRef,cls, "setSerial", "([B)V");

    (*envRef)->CallVoidMethod(envRef, cls, setMac, device->mac);
    (*envRef)->CallVoidMethod(envRef, cls, setSerial, device->serial_number);
    (*envRef)->CallVoidMethod(envRef, cls, setIsAuthenticated, device->is_authorised);
    (*envRef)->CallVoidMethod(envRef, cls, setAppId, device->app_id);

    jobject obj = (*envRef)->NewObject(cls, constructor,NULL);

    jbyteArray nonce_ = (*envRef)->NewByteArray(envRef,9);
    (*envRef)->SetByteArrayRegion(envRef, nonce_, 0, 9, (const jbyte*) nonce );

    jint ret = (*envRef)->CallIntMethod(envRef, coreInterfaceRef, interfaceMethodHMCtwCustomCommandReceived, obj,nonce_);

    jbyte* nonce_array = (*envRef)->GetByteArrayElements(envRef, nonce_, NULL);
    memcpy(nonce,nonce_array,9);

    return ret;
}

void hm_ctw_device_certificate_registered(hm_device_t *device, uint8_t *public_key, uint8_t error)
{

}

uint32_t hm_ctw_pairing_requested(){

    return 0;
}