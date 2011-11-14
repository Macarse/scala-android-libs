package net.virtualvoid.android.scalainstaller.tests

import junit.framework.Assert._
import _root_.android.test.AndroidTestCase

class UnitTests extends AndroidTestCase {
  def testPackageIsCorrect {
    assertEquals("net.virtualvoid.android.scalainstaller", getContext.getPackageName)
  }
}