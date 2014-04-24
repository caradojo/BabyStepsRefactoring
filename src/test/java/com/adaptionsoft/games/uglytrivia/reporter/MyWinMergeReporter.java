package com.adaptionsoft.games.uglytrivia.reporter;

import java.text.MessageFormat;
import org.approvaltests.reporters.GenericDiffReporter;

/**
 * Need JDK 1.7, does not work with JDK 1.6 problem with space inside path (cf. DIFF_PROGRAM).
 * @author Remy Sanlaville
 *
 */
public class MyWinMergeReporter extends GenericDiffReporter
{
  public static final MyWinMergeReporter INSTANCE     = new MyWinMergeReporter();                       ;
  static final String                  DIFF_PROGRAM = "C:\\Program Files (x86)\\WinMerge\\WinMergeU.exe";
  static final String                  MESSAGE      = MessageFormat.format("Unable to find WinMerge at {0}"
                                                        + "\nYou can install it at http://winmerge.org/",
                                                        DIFF_PROGRAM);
  public MyWinMergeReporter()
  {
    super(DIFF_PROGRAM, MESSAGE);
  }
}