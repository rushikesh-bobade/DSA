                sum += weights[c - 'a'];
            }

            int mod = sum % 26;
            result.append((char)('z' - mod));
        }

        return result.toString();
    }
}
