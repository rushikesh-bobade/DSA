
            } else if (ch == '%') {

                long curLen = len[i + 1];
                k = curLen - 1 - k;

            } else { // '*'
                // nothing to do
            }
        }

        return '.';
    }
}
