SUMMARY = "A simple Hello World autostart example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "ejemplo-autostart.service"

SRC_URI = "file://ejemplo-autostart.service"
FILES:${PN} += "${systemd_unitdir}/system/ejemplo-autostart.service"

do_install() {
  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/ejemplo-autostart.service ${D}${systemd_unitdir}/system
  # sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_unitdir}/system/ejemplo-autostart.service 
}
