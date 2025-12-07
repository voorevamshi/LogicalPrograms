package com.vmc.netcracker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ErrorPriorityProcessor {

    public static Optional<ErrorInfo> findHighestPriorityError(
            List<ErrorInfo> configErrors,
            List<String> serverErrorCodes) {

        Map<String, ErrorInfo> errorLookup =
                configErrors.stream()
                        .collect(Collectors.toMap(
                                ErrorInfo::getCode,
                                e -> e,
                                (e1, e2) -> e2
                        ));

        return serverErrorCodes.stream()
                .map(errorLookup::get)
                .filter(Objects::nonNull)
                .min(Comparator.comparing(ErrorInfo::getPriority));
    }
//I optimized the solution by using a lookup map and a single stream with min() to avoid unnecessary sorting
    //and multiple traversals.
    public static void main(String[] args) {

        List<ErrorInfo> errorsConfiguration = Arrays.asList(
                new ErrorInfo("E-1334", 4),
                new ErrorInfo("E-7264", 2),
                new ErrorInfo("E-7264", 2),
                new ErrorInfo("E-2234", 1),
                new ErrorInfo("E-9134", 3),
                new ErrorInfo("E-7834", 5)
        );

        List<String> errorsFromServer =
                Arrays.asList("E-7834", "E-7264", "S-3364");

        Optional<ErrorInfo> highestPriority =
                findHighestPriorityError(errorsConfiguration, errorsFromServer);

        highestPriority.ifPresent(System.out::println);
    }
   /* 
    Why This Approach Is Better Than Yours
    
    Your Approach			Optimized Approach
    Multiple streams		Single map + single stream
    Sorting used			No sorting used min method
    Map of code → priority	Map of code → ErrorInfo
    Extra grouping			Group only if needed
    .get() risk				Safe Optional
    More memory				Less memory
    */
    
}

