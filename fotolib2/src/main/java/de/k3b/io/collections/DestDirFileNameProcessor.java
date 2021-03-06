/*
 * Copyright (c) 2017 by k3b.
 *
 * This file is part of AndroFotoFinder / #APhotoManager.
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>
 */

package de.k3b.io.collections;

import java.io.File;
import java.util.Date;

import de.k3b.io.FileProcessor;
import de.k3b.io.IFileNameProcessor;

/**
 * Created by k3b on 17.10.2017.
 */

public class DestDirFileNameProcessor  extends FileProcessor implements IFileNameProcessor {
    private final File destDirFolder;
    public DestDirFileNameProcessor(File destDirFolder) {
        this.destDirFolder = destDirFolder;
    }

    /**
     * Calculate next free file name for sourceFile. Sourcefiles should be ordered asc by sourceFileDate
     *
     * @param sourceFile
     * @param sourceFileDate
     * @param firstFileInstanceNumber number where numbering starts with. -1 : auto  @return next absoulte renamed file.
     */
    @Override
    public File getNextFile(File sourceFile, Date sourceFileDate, int firstFileInstanceNumber) {
        File dest = renameDuplicate(new File(this.destDirFolder, sourceFile.getName()));
        return dest;
    }
}
