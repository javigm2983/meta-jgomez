SUMMARY = "A simple Qt application autostart example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS += "qtbase"

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "qt-ejemplo-2.service"

SRC_URI = "\
  file://qt-ejemplo-2.service \
  file://Qt_ejemplo_2 \
  file://Qt_ejemploMeler \
  file://qt-ejemplo-2-launch.sh"
FILES:${PN} += "${systemd_unitdir}/system/qt-ejemplo-2.service"

do_install() {
  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/Qt_ejemplo_2 ${D}${bindir}
  install -m 0755 ${WORKDIR}/Qt_ejemploMeler ${D}${bindir}
  install -m 0755 ${WORKDIR}/qt-ejemplo-2-launch.sh ${D}/${bindir}
  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/qt-ejemplo-2.service ${D}${systemd_unitdir}/system
}
