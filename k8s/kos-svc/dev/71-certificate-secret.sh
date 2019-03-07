#!/bin/sh

#kubectl create secret generic certificate-email --from-file=email.cer -n dev-kos
kubectl create secret generic custom-cert --from-file=service-cert.crt
