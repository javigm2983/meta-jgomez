SUMMARY = "CAN interface can0 setup recipe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "can0-setup.service"

SRC_URI = "file://can0-setup.service"
FILES:${PN} += "${systemd_unitdir}/system/can0-setup.service"

do_install() {
  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/can0-setup.service ${D}${systemd_unitdir}/system
}